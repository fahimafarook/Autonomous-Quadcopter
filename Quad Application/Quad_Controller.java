import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Polygon;

import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;

public class Quad_Controller extends javax.swing.JFrame {
		static  JFrame frame1;
		static PathMaker graph = new PathMaker();
		static PieChart pie = new PieChart();
		 String dynamic_arr[]=new String[4];
	   Image img = Toolkit.getDefaultToolkit().getImage("..\\images\\original.jpg");
	   static int arun_x1,arun_y1,arun_x2,arun_y2,arun_freq;
	   static double plots[][];
	   public Quad_Controller() throws IOException {
		      frame1=new JFrame();
			  frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			  frame1.setSize(1366,768);
			  //frame1.setLocation(0,0);
			  frame1.setExtendedState(JFrame.MAXIMIZED_BOTH);
			  frame1.setVisible(true);
			
		    //  frame1.add(new Quad_Controller());
	      
	   }
	   void find_points() {
	        ArrayList<Double> x_points = new ArrayList<Double>();
	        ArrayList<Double> y_points = new ArrayList<Double>();
	        int x=arun_x2;
	        int y=arun_y2;
	        int freq=arun_freq;
	        
	        if(x>0 && y>0)
	        {
	            int flag=0;
	            int var=0;
	            for(int i=0;i<=y;i++)
	            {
	                if(i%freq!=0)
	                continue;
	                if(i%2==0)
	                {
	                    var=0;
	                    flag=0;
	                }
	                else 
	                {
	                    var=x;
	                    flag=1;
	                }
	              for(int j=0;j<=x;j++)
	              {
	                  if(var%freq==0){
						x_points.add((double)var);
						y_points.add((double)i);
						System.out.print("\t"+var+" "+i+"\t"+"\t"+freq);
					  }
	                  if(flag==0)
	                    var++;
	                   else 
	                       var--;
	                    
	               }
	               System.out.println();
	            }
	        }
	        if(x<0 && y>0)
	        {
	            
	            int flag=0;
	            int var=0;
	            for(int i=0;i<=y;i++)
	            {
	                if(i%freq!=0)
	                continue;
	                if(i%2==0)
	                {
	                    var=0;
	                    flag=0;
	                }
	                else 
	                {
	                    var=x;
	                    flag=1;
	                }
	              for(int j=0;j>=x;j--)
	               {  
	                   if(var%freq==0){
						x_points.add((double)var);
						y_points.add((double)i);
						System.out.print("\t"+var+" "+i+"\t"+"\t"+freq);
					  }
	                   if(flag==0)
	                    var--;
	                   else 
	                       var++;
	                    
	               }
	               System.out.println();
	            }
	        }
	        
	        if(x<0 && y<0)
	        {
	            
	            int flag=0;
	            int var=0;
	            for(int i=0;i>=y;i--)
	            {
	                if(i%freq!=0)
	                continue;
	                if(i%2==0)
	                {
	                    var=0;
	                    flag=0;
	                }
	                else 
	                {
	                    var=x;
	                    flag=1;
	                }
	              for(int j=0;j>=x;j--)
	               {  
	                 
	                   if(var%freq==0){
						x_points.add((double)var);
						y_points.add((double)i);
						System.out.print("\t"+var+" "+i+"\t"+"\t"+freq);
					  }
	                   if(flag==0)
	                    var--;
	                   else 
	                    var++;
	                    
	               }
	               System.out.println();
	            }
	        }
	        
	        if(x>0 && y<0)
	        {
	            int flag=0;
	            int var=0;
	            for(int i=0;i>=y;i--)
	            {
	                if(i%freq!=0)
	                continue;
	                if(i%2==0)
	                {
	                    var=0;
	                    flag=0;
	                }
	                else 
	                {
	                    var=x;
	                    flag=1;
	                }
	              for(int j=0;j<=x;j++)
	               {  
	                 
	                   if(var%freq==0){
						x_points.add((double)var);
						y_points.add((double)i);
						System.out.print("\t"+var+" "+i+"\t"+"\t"+freq);
					  }
	                   if(flag==0)
	                    var++;
	                   else 
	                    var--;
	                    
	               }
	               System.out.println();
	            }
	        }
	        graph.coords[0] =new double[x_points.size()];
	        graph.coords[1] =new double[y_points.size()];
	        for(int i = 0; i < x_points.size(); i++){
	        	graph.coords[0][i] = x_points.get(i);
	        	graph.coords[1][i] = y_points.get(i);
	        }
	        }
	   void m1()
	   {
		         JPanel pan=new JPanel() {
			     
		         @Override
		         public void paintComponent(Graphics g) {
		            super.paintComponent(g);
		            g.drawImage(img, 0, 0, null);
		            
		            JTextField t1 =new JTextField();
		    	    t1.setBackground((new Color(204, 214, 193)));
		    	    Font f = new Font("Calibri Light",Font.PLAIN,24);
		    	    t1.setForeground (Color.white);
		    	    t1.setBackground((new Color(96, 96, 96)));
		    	    t1.setFont(f);
		    	    
		    	    JLabel l1 = new JLabel("Quadcopter-Ref :"); 
		    	    l1.setFont (l1.getFont ().deriveFont (22.0f));
		    	    l1.setForeground (Color.white);
		    	    l1.setBackground (new Color(22, 206, 219));
		    	    l1.setFont(f);
		    	    
		    	    JLabel error_q_no = new JLabel("! error code"); 
		    	    error_q_no .setFont (l1.getFont ().deriveFont (16.0f));
		    	    error_q_no .setForeground (Color.red);
		    	    error_q_no .setBackground (new Color(22, 206, 219));
		    	    error_q_no .setFont(f);
		    	    
		    	    JLabel error_pass = new JLabel("! error password"); 
		    	    error_pass .setFont (l1.getFont ().deriveFont (16.0f));
		    	    error_pass .setForeground (Color.red);
		    	    error_pass .setBackground (new Color(22, 206, 219));
		    	    error_pass.setFont(f);
		    	    
		    	    JLabel lblPassword = new JLabel("Password          :");
		    	    lblPassword.setFont (l1.getFont ().deriveFont (22.0f));
		    	    lblPassword.setForeground (Color.white);
		    	    lblPassword.setBackground (new Color(22, 206, 219));
		    	    lblPassword.setFont(f);
		    	  
		    	    
		            final JPasswordField pfPassword = new JPasswordField(20);
		            pfPassword .setBackground((new Color(96, 96, 96)));
		            pfPassword .setForeground (Color.white);
		            pfPassword .setFont(f);
		            
		            f = new Font("Calibri Light",Font.PLAIN,18);
		            
		    	    JButton b=new JButton("Proceed"); 
		    	    b.setForeground(Color.white);
		    	    b.setBackground((new Color(99,99,99)));
		    	    b.setFont(f);  
		    	    
		    	    JButton retry_b=new JButton("retry"); 
		    	    retry_b.setForeground(Color.white);
		    	    retry_b.setBackground((new Color(99,99,99)));
		    	    retry_b.setFont(f);
		    	      
		    	    
		    	    b.setBounds(460,270,95,30);  
		    	    l1.setBounds(130,100, 200,30); 
		    	    lblPassword.setBounds(130,170,200,30);
		    	    t1.setBounds(310,100, 250,30);  
		    	    pfPassword.setBounds (310,170,250,30);
		    	    retry_b.setBounds(320,270,95,30);
		    	   
		    	    
		    	    setLayout(null);
		    	    add(t1);
		    	    add(l1);
		    	    add(b); 
		    	    add(retry_b);
		    	    add(pfPassword);     
		    	    add(lblPassword);
		    	    setSize(1366,768);
		
		    	    b.addActionListener(new ActionListener(){  
		    	    	int flag=0;
		    	    	public void actionPerformed(ActionEvent e){
		    	    		
		    	    		 String s1=new String(pfPassword.getPassword());
		    	    		 String s2=new String(t1.getText());
		    	    		  if(!s2.equals("AFH#"))
		    	    		 {
		    	    			 flag=1;
		    	    			 add(error_q_no);
		    	    			 error_q_no.setBounds(560,100, 200,30);
		    	    		 }
		    	    		 if(!s1.equals("12345"))
		    	    		 {
		    	    			 flag=1;
		    	    			 add(error_pass);
		    	    			 error_pass.setBounds(560,170, 200,30);
		    	    		 }
		    	    		 else if(flag==0) {
		    	    		 m2();
		    	    		 setVisible(false);
		    	    	        } 
		    	    		 m2();
		    	    		 setVisible(false);
		    	    		 
		    	    	 
		    	    		 
		    	    		}
		    	    	    });
		    	    
		    	    retry_b.addActionListener(new ActionListener(){ 
		    	    	public void actionPerformed(ActionEvent e){
		    	    		setVisible(false);
		    	    		 m1();
		    	    		}
		    	    	    });
		         }
		         };
		         frame1.add(pan);
		     
	   }
	   @Override
	   public void setBounds(int x, int y, int width, int height) {
	       super.setBounds(x, y, width, height);

	       // The arrow is the first (and only) component
	       // that is added by default
	       Component[] comps = getComponents();
	       if (comps != null && comps.length >= 1) {
	           Component arrow = comps[0];
	           // 20 is the default width of the arrow (for me at least)
	           arrow.setSize(20, height);
	           arrow.setLocation(width - arrow.getWidth(), 0);
	       }
	   }
	   
	   void m2()
	   {
		   JPanel pan=new JPanel() {
			     
		         @Override
		         public void paintComponent(Graphics g) {
		            super.paintComponent(g);
		            g.drawImage(img, 0, 0, null);
		            String seed_arr[]={"s-1  (10-20)","s-2  (10-20)","s-4  (20-30)","s-5 (20-30)","s-8  (30-40)"};  
		            dynamic_arr=seed_arr;
		    	   
		            Font f_common = new Font("Calibri Light",Font.PLAIN,22);
		            
		            JLabel temp1 = new JLabel("Set temperature : "); 
		    	    temp1.setFont (temp1.getFont ().deriveFont (20.0f));
		    	    temp1.setForeground (Color.white);
		    	    temp1.setBackground (Color.white);
		    	    temp1.setFont(f_common);
		    	    
		    	    String temprature[]={"10-20°C","20-30°C","30-40°C"};        
		    	    JComboBox cb1=new JComboBox(temprature);    
		    	    //cb.setSize(500,500);      
		    	    Font font = new Font("",Font.PLAIN,14);
		    	    cb1.setFont(font.deriveFont(18.0f));
		    	    cb1.setBackground(new Color(96, 96, 96));
		    	    cb1.setForeground(Color.white);
		    	    cb1.setFont(f_common);
		    	      
		                 JComboBox cb2=new JComboBox(dynamic_arr);   
			    	   
			    	      cb2.setFont(font.deriveFont(18.0f));
			    	      cb2.setBackground(new Color(96, 96, 96));
			    	      cb2.setForeground(Color.white);
			    	      cb2.setFont(f_common);
			    	      
			    	                                    
			    	        JLabel freq_l = new JLabel("frequency          :"); 
				    	    freq_l.setFont (temp1.getFont ().deriveFont (20.0f));
				    	    freq_l.setForeground (Color.white);
				    	    freq_l.setBackground (new Color(22, 206, 219));
				    	    freq_l.setFont(f_common);
			    	      
			    	        String frequnecy[]={"5","7","10","12","15"};        
				    	    JComboBox cb4=new JComboBox(frequnecy);         
				    	    //Font font = new Font("",Font.PLAIN,14);
				    	    cb4.setFont(font.deriveFont(18.0f));
				    	    cb4.setBackground(new Color(96, 96, 96));
				    	    cb4.setForeground(Color.white);
				    	    
				    	    cb4.setFont(f_common);
				    	    
				    	    
				    	    
				    	    ActionListener cb1ActionListener = new ActionListener() {//add actionlistner to listen for change
				                @Override
				                public void actionPerformed(ActionEvent e) {
				                	
				                    String s = (String) cb1.getSelectedItem();//get the selected item
				                    if(s.equals("10-20°C"))
				                    {
				                    	cb2.removeAllItems();
				                    	cb2.insertItemAt("s-1  (10-20)", 0);
				                    	cb2.insertItemAt("s-2  (10-20)", 1);
				                    	cb2.insertItemAt("s-3  (10-20)", 2);
				               
				                    }
				                    else if(s.equals("20-30°C"))
				                    {
				                        cb2.removeAllItems();
				                    	cb2.insertItemAt("s-4  (20-30)", 0);
				                    	cb2.insertItemAt("s-5  (20-30)", 1);
				                    	cb2.insertItemAt("s-6  (20-30)", 2);
				                    	
				                    }
				                    else if(s.equals("30-40°C"))
				                    {
				                        cb2.removeAllItems();
				                    	cb2.insertItemAt("s-7  (30-40)", 0);
				                    	cb2.insertItemAt("s-8  (30-40)", 1);
				                    	cb2.insertItemAt("s-9  (30-40)", 2);
				                    	
				                    }
				                
				                }
				                };
				                
			    	      
			    	      ActionListener cb2ActionListener = new ActionListener() {//add actionlistner to listen for change
				                @Override
				                public void actionPerformed(ActionEvent e) {
				                	
				                  /*  String s = (String) cb2.getSelectedItem();//get the selected item
				                    if((s.equals ("s-1  (10-20)") ) ||  (s.equals("s-4  (20-30)"))  ||  (s.equals("s-6  (30-40)")))
				                    {
				                    	cb4.removeAllItems();
				                    	cb4.insertItemAt("5", 0);
				                    	cb4.insertItemAt("7", 1);
				                    }
				                    
				                    else if((s.equals ("s-2  (10-20)") ) ||  (s.equals("s-5 (20-30)"))  ||  (s.equals("s-5  (30-40)")))
				                    {
				                    	cb4.removeAllItems();
				                    	cb4.insertItemAt("10", 0);
				                    	cb4.insertItemAt("12", 1);
				                    }
				                    
				                    else if((s.equals ("s-3  (10-20)") ) ||  (s.equals("s-6 (20-30)"))  ||  (s.equals("s-8  (30-40)")))
				                    {
				                    	cb4.removeAllItems();
				                    	cb4.insertItemAt("15", 0);
				                    	cb4.insertItemAt("17", 1);
				                    }*/			                    
				                }
				                };
				               
			   
		    	      
				                cb1.addActionListener(cb1ActionListener );   // action listner
					    	    cb2.addActionListener(cb2ActionListener );   // action listner  
					    	      
					    	    
			            JLabel seed = new JLabel("Seed name        : "); 
			    	    seed.setFont (temp1.getFont ().deriveFont (20.0f));
			    	    seed.setForeground (Color.white);
			    	    seed.setBackground (new Color(22, 206, 219));
			    	    seed.setFont(f_common);
			    	    
			    	  
			    	      JLabel start_coordinates= new JLabel("start points        :"); 
			    	      start_coordinates.setFont (temp1.getFont ().deriveFont (16.0f));
			    	      start_coordinates.setForeground (Color.white);
			    	      start_coordinates.setBackground (new Color(22, 206, 219));
			    	      start_coordinates.setFont(f_common);
			    	      
			    	      JTextField x1_l =new JTextField("0");
				    	  x1_l.setBackground((new Color(96, 96, 96)));
				    	  Font f = new Font("",Font.PLAIN,18);
				    	  x1_l.setForeground(Color.white);
				    	  x1_l.setFont(f_common);
				    	  
				    	  JTextField y1_l =new JTextField("0");
				    	  y1_l.setBackground((new Color(96, 96, 96)));
				    	  //Font f = new Font("",Font.PLAIN,18);
				    	  y1_l.setForeground(Color.white);
				    	  y1_l.setFont(f);
				    	  
				    	  JLabel end_coordinates= new JLabel("end points          :") ;
			    	      end_coordinates.setForeground (Color.white);
			    	      end_coordinates.setBackground (new Color(22, 206, 219));
			              end_coordinates.setFont(f_common);
			              
			              
			              JLabel temp_l_x1=new JLabel("x1");
			              temp_l_x1.setForeground (new Color(137,204,204));
			              f = new Font("Calibri Light",Font.PLAIN,20);
			              temp_l_x1.setFont(f);
			              
			              JLabel temp_l_y1=new JLabel("y1");
			              temp_l_y1.setForeground (new Color(137,204,204));
			              temp_l_y1.setFont(f);
			              
			              JLabel temp_l_x2=new JLabel("x2");
			              temp_l_x2.setForeground (new Color(159, 227, 217));
			              temp_l_x2.setFont(f);
			              
			              JLabel temp_l_y2=new JLabel("y2");
			              temp_l_y2.setForeground (new Color(159, 227, 217));
			              temp_l_y2.setFont(f);

			              JLabel ft=new JLabel("ft");
			              ft.setForeground (new Color(137,204,204));
			              ft.setFont(f);
			              
			              
			    	      
			    	      JTextField x2_l =new JTextField("0");
				    	  x2_l.setBackground((new Color(96, 96, 96)));
				    	  //Font f = new Font("",Font.PLAIN,18);
				    	  x2_l.setForeground(Color.white);
				    	  x2_l.setFont(f);
				    	  
				    	  JTextField y2_l =new JTextField("0");
				    	  y2_l.setBackground((new Color(96, 96, 96)));
				    	  //Font f = new Font("",Font.PLAIN,18);
				    	  y2_l.setForeground(Color.white);
				    	  y2_l.setFont(f);
				    	    
				    	  JLabel alt_l = new JLabel("Set altitude         :"); 
				    	  alt_l.setFont (temp1.getFont ().deriveFont (16.0f));
				    	  alt_l.setForeground (Color.white);
				    	  alt_l.setBackground (new Color(190,196, 207));
				    	  alt_l.setFont(f_common);
		    	     
				    	  JTextField alt =new JTextField("10");
					      alt.setBackground((new Color(96, 96, 96)));
					      //Font f = new Font("",Font.PLAIN,18);
					      alt.setForeground(Color.white);
					      alt.setFont(f);
		    	    
			    	      JButton vis=new JButton("visualize"); 
				    	  vis.setForeground(Color.white);
				    	  vis.setBackground(new Color(97,97,97));
				    	  Font f2 = new Font("Calibri Light",Font.BOLD,20);
					      vis.setFont(f2);
					      
					      JButton ana=new JButton("analysis"); 
		   		    	  ana.setForeground(Color.white);
		   		    	  ana.setBackground(new Color(97,97,97));
		   		    	  Font f3 = new Font("Calibri Light",Font.BOLD,20);
		   			      ana.setFont(f2);
		   			      
		   			        
		   			      
		   			      vis.addActionListener(new ActionListener(){  
		   		    	    	public void actionPerformed(ActionEvent e){  
		   		    	    		arun_x1=Integer.parseInt(x1_l.getText());
		   		    	    		arun_y1=Integer.parseInt(y1_l.getText());
		   		    	    		arun_x2=Integer.parseInt(x2_l.getText());
		   		    	    		arun_y2=Integer.parseInt(y2_l.getText());
		   		    	    		arun_freq=Integer.parseInt((String)cb4.getSelectedItem());
		   		    	    		System.out.println(arun_x1+" "+arun_y1+" "+arun_x2+" "+arun_y2);
									find_points();
		   		    	    		m3();
		   		    	    	}   
		   		    	    	    });
		   			      
		   			   ana.addActionListener(new ActionListener(){  
	  		    	    	public void actionPerformed(ActionEvent e){  
	  		    	    		arun_x1=Integer.parseInt(x1_l.getText());
	  		    	    		arun_y1=Integer.parseInt(y1_l.getText());
	  		    	    		arun_x2=Integer.parseInt(x2_l.getText());
	  		    	    		arun_y2=Integer.parseInt(y2_l.getText());
	  		    	    		arun_freq=Integer.parseInt((String)cb4.getSelectedItem());
								find_points();
	  		                	m4();
	  		    	    }   
	  		    	    	    });
		   	 	       
		   	         vis.setBounds(130,550,150,30); 
		   	         add(vis);
			 	    
			    	      
			    	     temp1.setBounds         (130,100, 200,30); 
			    	     cb1.setBounds           (330, 100,150,30); 
			    	     seed.setBounds         (130,170, 200,30);
			    	     cb2.setBounds          (330, 170,150,30);
			    	     freq_l.setBounds       (130, 240,160,34);
			    	     cb4.setBounds           (330, 240,150,30);
			    	     start_coordinates.setBounds(130,315,400,30);//
			    	     
			    	     temp_l_x1.setBounds(390,315,400,30);
			    	     temp_l_y1.setBounds(490,315,400,30);
			    	     temp_l_x2.setBounds(390,385,400,30);
			    	     temp_l_y2.setBounds(490,385,400,30);
			    	     ft.setBounds(390,450,400,30);
			    	     
			    	     x1_l.setBounds          (330,310, 50,30);
			    	     y1_l.setBounds         (430,310, 50,30);
			    	     end_coordinates.setBounds(130,380,400,30);
			    	     x2_l.setBounds          (330,380, 50,30);
			    	     y2_l.setBounds         (430,380, 50,30);
			    	     alt_l.setBounds           (130,450,400,30);
			    	     alt.setBounds         (330,450, 50,30);
			    	     ana.setBounds           (400,550,150,30); 
			    	     
		
			    	   
		    	   
		    	    add(cb1);
		    	    add(cb2);
		    	    add(cb4);
		    	    add(seed);
		    	    add(temp1);
		    	    add(freq_l);
		    	    add(ana);
		    	    add(start_coordinates);
		    	    add(x1_l);
		    	    add(y1_l);
		    	    add(end_coordinates);
		    	    add(x2_l);
		    	    add(y2_l);
		    	    add(alt_l);
		    	    add(alt);
		    	    
		    	    add(temp_l_x1);
		    	    add(temp_l_y1);
		    	    add(temp_l_x2);
		    	    add(temp_l_y2);
		    	    add(ft);
		    	    
		    	    
		    	    setLayout(null);  
		    	    setSize(1366,768);
		    	    setVisible(true);
		    	    revalidate();
		    	    repaint();
		         }
		         };
		         frame1.add(pan);
		         frame1.setVisible(true);
		     
	  
	   } 
	   
	   void m3()
	   {
		    graph.show_path();
		    
	   }
	   void m4()
	   {
		    Random random = new Random();
		    boolean dropped[] = new boolean[graph.coords[0].length];
		    for(int i=0; i<graph.coords[0].length; i++)
		    	dropped[i] = random.nextBoolean();
		    graph.show_path(dropped);
			pie.show_piechart(dropped);
	   }
	  
	   public static void main(String[] args) throws Exception {
	      new Quad_Controller().m1();
	      frame1.setVisible(true);
	   }
	  
	}
	 
///////////////////////////////////////Graph///////////////////////////
class PathMaker {
	static JFrame f;
	double min_max[][] = new double[2][2];
	boolean min_max_found = false;
	double coords[][] = new double[2][];
	public PathMaker(){
		f = new JFrame();
        f.setSize(750,750);
        f.setLocation(0,0);
        f.setVisible(true);
	}
	
	public static void wait(int ms){
		LocalTime startTime = LocalTime.now();
        while(Duration.between(startTime, LocalTime.now()).toMillis() < 500);
/*        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
  */  }
	public void find_gps(){
		
	}
	public void show_path(){
		for(int i=0; i<coords[0].length; i++)
			System.out.print(coords[0][i]+","+coords[1][i]+"...");
		System.out.println();
		if(!min_max_found)
			getExtremeValues(coords);
		for(int i=0; i<coords[0].length; i++){
			f.getContentPane().removeAll();
			f.add(new PlotPanel(coords, min_max, i+1));
			f.setVisible(true);
		//	wait(500);
			}
	}
	public void show_path(boolean[] dropped){
		for(int i=0; i<coords[0].length; i++)
			System.out.print(coords[0][i]+","+coords[1][i]+"...");
		System.out.println();
		if(!min_max_found)
			getExtremeValues(coords);
		f.getContentPane().removeAll();
		f.add(new PlotPanel(coords, min_max, dropped));
		f.setVisible(true);
	}
	/*
    public static void main(String[] args) {
        PlotGraph graph = new PlotGraph();
     	graph.show_path(new double[][]{{1.0,1.0,2.0,2.0,3.0,3.0},{1.0,2.0,2.0,1.0,1.0,3.0}});
	    f.setVisible(true);     	
		graph.show_path(new double[][]{{1.0,1.0,2.0,2.0,3.0,3.0},{1.0,2.0,2.0,1.0,1.0,3.0}}, new boolean[]{true,true,true,false,false,true});
	    f.setVisible(true);

		}
		*/
    private void getExtremeValues(double[][] d) {
		for(int i=0; i<d.length; i++){
			double min = Double.MAX_VALUE;
		    double max = -min;
		    for(int j = 0; j < d[i].length; j++) {
				if(d[i][j] < min)
			       	min = d[i][j];
			    if(d[i][j] > max)
			      	max = d[i][j];
			}
			min_max[i][0] = min;
			min_max[i][1] = max;
	    }
		min_max_found = true;
	}
}
 
class PlotPanel extends JPanel {
    
	Image img = Toolkit.getDefaultToolkit().getImage("..\\images\\land.jpg");
	Color colors[];
	double[] x;
    double[] y;
    double xMin;
    double xMax;
    double yMin;
    double yMax;
    final int PAD = 20;
	
    public PlotPanel(double[][] coords, double min_max[][], int no_of_plots) {
		xMin = min_max[0][0]-2;
		xMax = min_max[0][1]+2;
		yMin = min_max[1][0]-2;
		yMax = min_max[1][1]+2;
		x = new double[no_of_plots];
		y = new double[no_of_plots];
		colors = new Color[no_of_plots];
		int i = 0;
		
		for(double ix : x){
			colors[i] = Color.GREEN;
			x[i] = coords[0][i];
			y[i] = coords[1][i++];
		}
        repaint();
    }
 
    public PlotPanel(double[][] coords, double min_max[][], boolean[] dropped) {
		xMin = min_max[0][0]-2;
		xMax = min_max[0][1]+2;
		yMin = min_max[1][0]-2;
		yMax = min_max[1][1]+2;
		x = new double[coords[0].length];
		y = new double[coords[0].length];
		colors = new Color[coords[0].length];
		int i = 0;
		
		for(double ix : x){
			colors[i] = dropped[i]?Color.GREEN: Color.RED;
			x[i] = coords[0][i];
			y[i] = coords[1][i++];
		}
        repaint();
    }
	
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, null);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();
        double xScale = (w - 2*PAD)/(xMax - xMin);
        double yScale = (h - 2*PAD)/(yMax - yMin);
        Point2D.Double origin = new Point2D.Double(); // Axes origin.
        Point2D.Double offset = new Point2D.Double(); // Locate data.
        if(xMax < 0) {
            origin.x = w - PAD;
            offset.x = origin.x - xScale*xMax;
        } else if(xMin < 0) {
            origin.x = PAD - xScale*xMin;
            offset.x = origin.x;
        } else {
            origin.x = PAD;
            offset.x = PAD - xScale*xMin;
        }
        if(yMax < 0) {
            origin.y = h - PAD;
            offset.y = origin.y - yScale*yMax;
        } else if(yMin < 0) {
            origin.y = PAD - yScale*yMin;
            offset.y = origin.y;
        } else {
            origin.y = PAD;
            offset.y = PAD - yScale*yMin;
        }
        g2.setPaint(Color.BLUE);
        // Draw abcissa.
        g2.draw(new Line2D.Double(PAD, origin.y, w-PAD, origin.y));
        // Draw ordinate.
        g2.draw(new Line2D.Double(origin.x, PAD, origin.x, h-PAD));
        g2.setPaint(Color.red);
        // Mark origin.
//        g2.fill(new Ellipse2D.Double(origin.x-2, origin.y-2, 4, 4));

			g2.setPaint(Color.black);
			Font font = g2.getFont();
			FontRenderContext frc = g2.getFontRenderContext();
			LineMetrics lm = font.getLineMetrics("0", frc);
			String s = String.format("%.1f", xMin);
			float width = (float)font.getStringBounds(s, frc).getWidth();
			double xt = offset.x + xScale*xMin;
			g2.drawString(s, (float)xt, (float)origin.y+lm.getAscent());
			s = String.format("%.1f", xMax);
			width = (float)font.getStringBounds(s, frc).getWidth();
			xt = offset.x + xScale*xMax;
			g2.drawString(s, (float)xt-width, (float)origin.y+lm.getAscent());
			s = String.format("%.1f", yMin);
			width = (float)font.getStringBounds(s, frc).getWidth();
			double yt = offset.y + yScale*yMin;
			g2.drawString(s, (float)origin.x+1, (float)yt+lm.getAscent());
			s = String.format("%.1f", yMax);
			width = (float)font.getStringBounds(s, frc).getWidth();
			yt = offset.y + yScale*yMax;
			g2.drawString(s, (float)origin.x+1, (float)yt);
 
        for(int i = 0; i < x.length; i++) {
            double x1 = offset.x + xScale*x[i];
            double y1 = offset.y + yScale*y[i];
			g2.setPaint(colors[i]);
            g2.fill(new Ellipse2D.Double(x1-5, y1-5, 10, 10));
			g2.setPaint(Color.BLACK);
			g.drawOval((int)(x1-6), (int)(y1-6), 12, 12);

			g2.setColor(Color.BLUE);
            g2.fill(new Ellipse2D.Double(x1-6, y1-20, 12, 12));
			g2.fill(new Polygon(new int[] { (int)(x1-5), (int)(x1+5), (int)x1 }, new int[] { (int)(y1-10), (int)(y1-10), (int)y1 }, 3));

            g2.drawString(String.format("%.1f", x[i])+","+String.format("%.1f", y[i]), (float)x1+3, (float)y1-3);
        }
        for(int i = 0; i < x.length-1; i++) {
            double x1 = offset.x + xScale*x[i];
            double y1 = offset.y + yScale*y[i];
            double x2 = offset.x + xScale*x[i+1];
            double y2 = offset.y + yScale*y[i+1];
			g2.setPaint(Color.green.darker());
            g2.draw(new Line2D.Double(x1, y1, x2, y2));
		}
    }
}

//////////////////////////////////PieChart////////////////////////////////////////////////

class Slice {
	  double value;
	  Color color;

	  public Slice(double value, Color color) {
	    this.value = value;
	    this.color = color;
	  }
	}

class MyComponent extends JComponent {
Slice[] slices;
int success, failure;
public MyComponent(Slice[] slices, int success, int failure) {
	  this.success = success;
	  this.failure = failure;
		this.slices = slices;
		setBounds(20,20,500,600);
		setVisible(true);
	}
public void paint(Graphics g) {
	  g.setColor(Color.BLACK);
	  g.drawString("Success("+Integer.toString(success)+")", 150, 480);
	  g.drawString("failure("+Integer.toString(failure)+")", 150, 510);
	  g.setColor(Color.GREEN);
	  g.fillRect(250, 472, 20, 10);
	  g.setColor(Color.RED);
	  g.fillRect(250, 502, 20, 10);
	  drawPie((Graphics2D) g, getBounds(), slices);
}

void drawPie(Graphics2D g, Rectangle area, Slice[] slices) {
  double total = 0.0D;
  for (int i = 0; i < slices.length; i++) {
    total += slices[i].value;
  }

  double curValue = 0.0D;
  int startAngle = 0;
  for (int i = 0; i < slices.length; i++) {
    startAngle = (int) (curValue * 360 / total);
    int arcAngle = (int) (slices[i].value * 360 / total);

    g.setColor(slices[i].color);
    g.fillArc(area.x, area.y, 400, 400, startAngle, arcAngle);
    curValue += slices[i].value;
  }
  g.setColor(Color.BLACK);
  g.drawOval(area.x, area.y, 400, 400);
}
}

class PieChart {
	static JFrame f;
	
	int success = 0;
	int failure = 0;
	public PieChart(){
		f = new JFrame();
	    f.setBounds(800,0,500, 750);
	    f.setLayout(null);
	    f.setVisible(true);

	}
/*
  PieChart pie = new PieChart();
	pie.show_piechart(new boolean[]{true,true,true,false,false});    

}
*/
public void show_piechart(boolean[] dropped){
	  	for(boolean b : dropped)

	  			if(b)
	  				success++;
	  			else
	  				failure++;
	  	f.getContentPane().removeAll();
	  	f.add( new MyComponent(new Slice[]{new Slice(success, Color.green),new Slice(failure, Color.red)}, success, failure));
	  	f.setVisible(true);
	  	success = failure = 0;
}
}