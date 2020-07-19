//#include<VirtualWire.h>
#include<Wire.h>
const int MPU=0x68; 
int16_t AcX,AcY,AcZ,Tmp,GyX,GyY,GyZ;
#include <Servo.h>
int f_l_current,f_r_current,b_l_current,b_r_current;
Servo ESC_front_left;
Servo ESC_front_right;
Servo ESC_back_left;
Servo ESC_back_right;

const byte interruptPin_1= 2;  // interupt for switch 
const byte interruptPin_2= 3;  // interupt for trans 
int min_speed=30;
int hover_speed=40;
int max_speed=60;
int current_speed=0;

int pot_val = 0;
int F_R = 0;
int F_L = 0;
int B_R = 0;
int B_L = 0;
  
int potValue;  // value from the analog pin
int height_to_check;  //set this variable inside methods

void setup() {
  Serial.begin(9600);
  Wire.begin();
  Wire.beginTransmission(MPU);  //from  gyro
  Wire.write(0x6B); 
  Wire.write(0);    
  Wire.endTransmission(true);//to

  pinMode(interruptPin_1, INPUT_PULLUP);
  attachInterrupt(digitalPinToInterrupt(interruptPin_1),interupt_code, LOW);

  pinMode(interruptPin_2, INPUT_PULLUP);
  attachInterrupt(digitalPinToInterrupt(interruptPin_2),interupt_code, LOW);

 
  ESC_front_left.attach(9,1000,2000); // (pin, min pulse width, max pulse width in microseconds)  
  ESC_front_right.attach(10,1000,2000);
  ESC_back_left.attach(5,1000,2000);
  ESC_back_right.attach(6,1000,2000);
  pin_control(0,0,0,0);
  delay(15000);     //-- important delay-----------------
  Serial.println("setupover");
}

int get_height()
{
   Serial.println("Enter height");
   while(!Serial.available());
    int height=Serial.read();
    Serial.print(height);
  //return false if height is achieved
  return height;
}
void pin_control(int front_left,int front_right,int back_left,int back_right)
{
      ESC_front_left.write(front_left);
      ESC_front_right.write(front_right);
      ESC_back_left.write(back_left);
      ESC_back_right.write(back_right); 
}

void up()
{
  /*height_to_check=10;
  for(;current_speed<max_speed;current_speed++) 
  {
    if(get_height()<height_to_check)
    {
      pin_control(current_speed,current_speed,current_speed,current_speed);
    }
    else 0.           
       {
        break;
       }
  }
  while(get_height()<height_to_check);
  for(;current_speed>=hover_speed;current_speed--)
    pin_control(current_speed,current_speed,current_speed,current_speed);*/
    for(int i=0;i<80;i++)
    {
      pin_control(i,i,i,i);
      Serial.println(i);
      delay(60);
    }
    for(int i=80;i>=0;i--)
    {
      pin_control(i,i,i,i);
      Serial.println(i);
      delay(60);
    }

    
    
  }
  

void down()
{
  Serial.print("inside down");
  height_to_check=48;//
  pin_control(min_speed,min_speed,min_speed,min_speed);
  while(get_height()>height_to_check);
  current_speed=min_speed;
  for(;current_speed>=0;current_speed--)
    pin_control(current_speed,current_speed,current_speed,current_speed);
}
void front()
{
  Serial.print("front");
  current_speed=hover_speed;
  
   for(;current_speed<=max_speed;current_speed++)  // loop for taking it to the max_speed from current 
   {
    delay(30);
    pin_control(hover_speed,hover_speed,current_speed,current_speed);
   }
   delay(200);
   for(;current_speed>=hover_speed;current_speed--)
   {
    pin_control(hover_speed,hover_speed,current_speed,current_speed);
    delay(30);
   }
   
}
void back()
{
  
}
void left()
{
  
}
void right()
{
  
}
void interupt_code()
{
  pin_control(0,0,0,0);
  delay(30000);
}
void get_pot_value()
{
  pot_val = map( analogRead(A0), 0, 1023, 0, 180);
  F_L = pot_val < 95 ? pot_val : F_L;
  pot_val = map( analogRead(A1), 0, 1023, 0, 180);
  F_R = pot_val < 95 ? pot_val : F_R;
  pot_val = map( analogRead(A2), 0, 1023, 0, 180);
  B_L = pot_val < 105 ? pot_val : B_L;
  pot_val = map( analogRead(A3), 0, 1023, 0, 180);
  B_R = pot_val < 95 ? pot_val : B_R;
  pin_control(F_R, B_L, F_R,B_L);
  //Serial.println(String(F_L)+" "+String(F_R)+" "+String(B_L)+" "+String(B_R));
  
}
void get_gyro_value()
{
    Wire.beginTransmission(MPU);
  Wire.write(0x3B);  
  Wire.endTransmission(false);
  Wire.requestFrom(MPU,12,true);  
  AcX=Wire.read()<<8|Wire.read();    
  AcY=Wire.read()<<8|Wire.read();  
  AcZ=Wire.read()<<8|Wire.read();  
  GyX=Wire.read()<<8|Wire.read();  
  GyY=Wire.read()<<8|Wire.read();  
  GyZ=Wire.read()<<8|Wire.read();  
  
  Serial.print("Accelerometer: ");
  Serial.print("X = "); Serial.print(AcX);
  Serial.print(" | Y = "); Serial.print(AcY);
  Serial.print(" | Z = "); Serial.println(AcZ);
}
void error_corr()
{ 
  if(AcY<-1100) //front left
  {
    while(AcY<-1100)
    {
      pin_control(--f_l_current,f_r_current,b_l_current,b_r_current);
      get_gyro_value();
      Serial.println("front_left---down");
      delay(150);
    }
  }
  else if(AcX<-4100)//fromt rite
  { 
    while(AcX<-4100)
    {
      pin_control(f_l_current,--f_r_current,b_l_current,b_r_current);
      get_gyro_value();
      Serial.println("front_rite---down");
      delay(150);
    }
  }
  else if(AcX>-100)//back left
  {
    while(AcX>-100)
    {
      pin_control(f_l_current,f_r_current,--b_l_current,b_r_current);
      get_gyro_value();
      Serial.println("back_left---down");
      delay(150);
    }
  }
  else if(AcY>2700)//back rite
  {
    while(AcY>2700)
    {
      pin_control(f_l_current,f_r_current,b_l_current,--b_r_current);
      get_gyro_value();
      Serial.println("back_rite---down");
      delay(150);
    }
  }
  Serial.println(" ");
  delay(333);
}
void loop() {
/*  for(int i=0;i<90;i++)
  {
  pin_control(++f_l_current,++f_r_current,++b_l_current,++b_r_current);
  get_gyro_value();
  error_corr();
  Serial.println(String(f_l_current)+" "+String(f_r_current)+" "+String(b_l_current)+" "+String(b_r_current));
  delay(200);
  
  }
*/
  get_pot_value();
  
  }


