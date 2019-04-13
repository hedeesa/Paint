package javaapplication15;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



public class makingCompliteFrame {
    Image image=null;
    JFrame frame;
    JMenuBar menuBar;
    JPanel panel,panel2,panelSmall1,panelSmall2,panelSmall3;
    JLabel clearLabel1,clearLabel2;
    PadDraw drawPad;
    String redius="";
    JTextField rediusField;
    String width1;
    String length1;
    Works actions=new Works(image);
    JTextField textField;
    JButton clearButton,clearPenButton,blackButton,yellowButton, redButton, pinkButton,blueButton, greenButton, colorsButton,typeString;
        JButton circleButton ;
        JButton squareButton ;
        JButton ellipseButton ;
    
    Icon iconE ,iconBl,iconY,iconR,iconM,iconB,iconG,iconE2,iconC;
        
    public void makeFrame() {
        
    frame = new JFrame("MyPaint - By Saeedeh Moghimi");
    frame.setBounds(500, 100, 600, 500);
    frame.setResizable(true);
    makePanels();
    menuBar = new JMenuBar();
    makeFileIcons();
    makeEditeIcon();
    frame.setJMenuBar(menuBar);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }
    
    public void makeFileIcons(){
        
       JMenu fileMenu=new JMenu("File");
       menuBar.add(fileMenu);
        
        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem saveItem = new JMenuItem("save");
        JMenuItem printItem = new JMenuItem("Print");
      
        actions.actionInFileIcon(exitItem, saveItem, panel);
        fileMenu.add(saveItem);
        fileMenu.add(printItem);
        fileMenu.add(exitItem);
        
    }
    public void makeEditeIcon(){
        
        JMenu editMenu =new JMenu("Edit");
        JMenuItem clearItem = new JMenuItem("Clear");
        actions.actionInEditeIcon(clearItem, drawPad);
        editMenu.add(clearItem);
        
        menuBar.add(editMenu);
    }
    
    public void makePanels(){
        panel=new JPanel();
        panelSmall1=new JPanel();
        panelSmall2 = new JPanel();
        panelSmall3=new JPanel();
        JPanel panelShape=new JPanel();
        drawPad = new PadDraw();
        
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelSmall1.setLayout(new  GridLayout(2,2));
        panelSmall2.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelSmall3.setLayout(new GridLayout(2,1));
        panelShape.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        Color color = new Color(255,255,255);
        panel.setBackground(color.darker());
        panel.setBorder(BorderFactory.createEtchedBorder());
        panel.setPreferredSize(new Dimension(400,130));
        
        panelSmall1.setBorder(BorderFactory.createEtchedBorder()); 
        panelSmall1.setPreferredSize(new Dimension(280,70));
        
        panelSmall2.setBorder(BorderFactory.createEtchedBorder());
        panelSmall2.setPreferredSize(new Dimension(570,35));
        
        panelSmall3.setBorder(BorderFactory.createEtchedBorder());
        panelSmall3.setPreferredSize(new Dimension(265,70));
        
        panelShape.setBackground(color.darker());
        panelShape.setBorder(BorderFactory.createEtchedBorder());
        panelShape.setPreferredSize(new Dimension(400,30));
        
        makeButtons();
        
              
     
    frame.add(drawPad, BorderLayout.CENTER);
    
          
          
          
         JLabel drawL=new JLabel("Draw Shapes :");
         panelShape.add(drawL);
         panelShape.add(circleButton);
         panelShape.add(squareButton);
         panelShape.add(ellipseButton);
      makeHideLabel();
        panelSmall1.add(clearLabel1);
        
        panelSmall1.add(clearButton);
        panelSmall1.add(clearLabel2);
        panelSmall1.add(clearPenButton);
        panelSmall2.add(yellowButton);
        panelSmall2.add(blackButton);
        panelSmall2.add(greenButton);
        panelSmall2.add(blueButton);
        panelSmall2.add(pinkButton);
        panelSmall2.add(redButton);
        panelSmall2.add(colorsButton);
        panelSmall3.add(textField);
        panelSmall3.add(typeString);
        makeHideLabel();
        panel.add(panelSmall2);
        panel.add(Box.createHorizontalStrut(1));
        panel.add(panelSmall1);
        panel.add(Box.createHorizontalStrut(1));
        panel.add(panelSmall3);
        panel.add(Box.createHorizontalStrut(20));
        frame.add(panel,BorderLayout.NORTH);
        frame.add(panelShape,BorderLayout.SOUTH);
        
        
    }
    public void makeHideLabel(){
        
        clearLabel1=new JLabel("Clear ALL",SwingConstants.CENTER);
        clearLabel2=new JLabel("Pen Erase",SwingConstants.CENTER);
        panelSmall1.setToolTipText("Erase Panel");
        panelSmall2.setToolTipText("Color Panel");
        panelSmall3.setToolTipText("Text Panel");
        
        
        
        
    }
    
    public void makeIconPictures(){
        
         iconE = new ImageIcon("C:\\Users\\Farhad\\Downloads\\Icons\\eraser.png");
         iconBl = new ImageIcon("C:\\Users\\Farhad\\Downloads\\Icons\\black.png");
         iconY = new ImageIcon("C:\\Users\\Farhad\\Downloads\\Icons\\yellow.png");
         iconR = new ImageIcon("C:\\Users\\Farhad\\Downloads\\Icons\\red.png");
         iconM = new ImageIcon("C:\\Users\\Farhad\\Downloads\\Icons\\pink.png");
         iconB = new ImageIcon("C:\\Users\\Farhad\\Downloads\\Icons\\blue.png");
         iconG = new ImageIcon("C:\\Users\\Farhad\\Downloads\\Icons\\green.png");
         iconE2 = new ImageIcon("C:\\Users\\Farhad\\Downloads\\Icons\\eraser2.png");
         iconC = new ImageIcon("C:\\Users\\Farhad\\Downloads\\Icons\\colors.png");
        
    }
    public void makeButtons(){
        makeIconPictures();
         clearButton = new JButton(iconE);
        clearPenButton = new JButton(iconE2);
         blackButton = new JButton(iconBl);
         yellowButton = new JButton(iconY);
         redButton = new JButton(iconR);
         pinkButton = new JButton(iconM);
         blueButton = new JButton(iconB);
         greenButton = new JButton(iconG);
         colorsButton=new JButton(iconC);
         typeString = new JButton("Get Text");
        circleButton = new JButton("Circle");
        squareButton = new JButton("Square");
         ellipseButton = new JButton("Ellipse");
        
        blackButton.setPreferredSize(new Dimension(60,20));
        yellowButton.setPreferredSize(new Dimension(60,20));       
        redButton.setPreferredSize(new Dimension(60,20));  
        pinkButton.setPreferredSize(new Dimension(60,20));
        blueButton.setPreferredSize(new Dimension(60,20));
        greenButton.setPreferredSize(new Dimension(60,20));
        colorsButton.setPreferredSize(new Dimension(60,20));
        circleButton.setPreferredSize(new Dimension(80,20));
        squareButton.setPreferredSize(new Dimension(80,20));
        ellipseButton.setPreferredSize(new Dimension(80,20));
        clearButton.setPreferredSize(new Dimension(100,30)); 
        textField=new JTextField(10);
        
        actions.actionClearPen(clearPenButton, drawPad);
	actions.actionClear(clearButton, drawPad);
        actions.actionBlack(blackButton, drawPad);
        actions.actionBlue(blueButton, drawPad);
        actions.actionYellow(yellowButton, drawPad);
        actions.actionRed(redButton, drawPad);
	actions.actionPink(pinkButton, drawPad);
	actions.actionGreen(greenButton, drawPad);
        actions.actionColor(colorsButton, drawPad);
        actions.actionTypeString(typeString, drawPad);
       actionShapeDraws();
        
        
          
        
        
        
    }
    public void actionShapeDraws(){
        
        circleButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
                    
			JFrame circleFrame=new JFrame("Draw Circle");
                        circleFrame.setBounds(500, 400, 320, 100);
                        circleFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
                        JRadioButton fillButton=new JRadioButton("FillCircle");
           
                         rediusField = new JTextField(10);
                        JLabel rediusLabel=new JLabel("redius");
                        JLabel comment=new JLabel("Please enter the radius of your circle");
                        JButton okButton=new JButton("OK");
                        circleFrame.add(comment);
                        circleFrame.add(fillButton);
                        circleFrame.add(rediusLabel);
                        circleFrame.add(rediusField);
                        circleFrame.add(okButton);
                        circleFrame.setVisible(true);
                        
                        okButton.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e) {
                                
                                 redius=rediusField.getText();
                                if(fillButton.isSelected()){
                                    circleFrame.setVisible(false);
                                    drawPad.drawFillCircle();
                                }
                                else{
                                    circleFrame.setVisible(false);
                                    drawPad.drawCircle();
                                }
                               
                                
                            }
                            
                        });      
		}
	});    
        
          squareButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
                    
                    JFrame rectangleFrame=new JFrame("Draw Rectangle");
                        rectangleFrame.setBounds(500, 400,420,120);
                        rectangleFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
                        JTextField lengthField = new JTextField(10);
                        JTextField widthField = new JTextField(10);
                        JLabel lengthLabel=new JLabel("length");
                        JLabel widthLabel=new JLabel("width");
                        JLabel comment=new JLabel("Please enter the length \nand width of your rectangle");
                        JButton okButton=new JButton("OK");
                        JRadioButton fillButton = new JRadioButton("Fill Rectangle");
                        rectangleFrame.add(comment);
                        rectangleFrame.add(fillButton);
                        rectangleFrame.add(lengthLabel);
                        rectangleFrame.add(lengthField);
                        rectangleFrame.add(widthLabel);
                        rectangleFrame.add(widthField);
                        rectangleFrame.add(okButton);
                        rectangleFrame.setVisible(true);
                        
                        okButton.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e) {
                                width1=widthField.getText();
                                length1=lengthField.getText();
                                if(fillButton.isSelected()){
                                    rectangleFrame.setVisible(false);
                                    drawPad.drawFillRectangle();
                                    
                                }
                                else{
                                    rectangleFrame.setVisible(false);
                                    drawPad.drawRectangle();
                                }
                               
                                
                            }
                            
                        });	
		}
	});   
          
           ellipseButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
                    
                    JFrame rectangleFrame=new JFrame("Draw Ellipse");
                        rectangleFrame.setBounds(500, 400,400,120);
                        rectangleFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
                        JTextField lengthField = new JTextField(10);
                        JTextField widthField = new JTextField(10);
                        JLabel lengthLabel=new JLabel("length");
                        JLabel widthLabel=new JLabel("width");
                        JLabel comment=new JLabel("Please enter the length and width of your ellipse");
                        JButton okButton=new JButton("OK");
                        JRadioButton fillButton = new JRadioButton("Fill Ellipse");
                        rectangleFrame.add(comment);
                        rectangleFrame.add(fillButton);
                        rectangleFrame.add(lengthLabel);
                        rectangleFrame.add(lengthField);
                        rectangleFrame.add(widthLabel);
                        rectangleFrame.add(widthField);
                        rectangleFrame.add(okButton);
                        rectangleFrame.setVisible(true);
                        
                        okButton.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e) {
                                width1=widthField.getText();
                                length1=lengthField.getText();
                                if(fillButton.isSelected()){
                                    rectangleFrame.setVisible(false);
                                    drawPad.drawFillEllipse();
                                    
                                }
                                else{
                                    rectangleFrame.setVisible(false);
                                    drawPad.drawEllipse();
                                }     
                            }
                            
                        });	
		}
	});   
          
        
    }
class PadDraw extends JComponent{
	
	
	Graphics2D graphics2D;
	int currentX, currentY, oldX, oldY;
	
        private String text;
        private Color color;

	
	public PadDraw(){
		setDoubleBuffered(false);
		addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				oldX = e.getX();
				oldY = e.getY();
			}
		});
		
		addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e){
				currentX = e.getX();
				currentY = e.getY();
                                
				if(graphics2D != null)
				graphics2D.drawLine(oldX, oldY, currentX, currentY);
                                
                            
				repaint();
				oldX = currentX;
				oldY = currentY;
			}

		});
	
	}

	public void paintComponent(Graphics g){
		if(image == null){
			image = createImage(getSize().width, getSize().height);
                        
			graphics2D = (Graphics2D)image.getGraphics();
			graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			clear();
                        
		}
		g.drawImage(image,0, 0, null);
                
                
	}

	public void clear(){
		graphics2D.setPaint(Color.white);
		graphics2D.fillRect(0, 0, getSize().width, getSize().height);
		graphics2D.setPaint(Color.black);
		repaint();
	}
	
	public void red(){
		graphics2D.setPaint(Color.red.brighter());
                
		repaint();
                
	}
	
	public void black(){
		graphics2D.setPaint(Color.black);
                graphics2D.drawLine(oldX, oldY, currentX, currentY);
                graphics2D.drawLine(oldX, oldY, currentX, currentY);
                graphics2D.setFont(new Font("Dialog",Font.BOLD,12));
		repaint();
	}
	
	public void magenta(){
		graphics2D.setPaint(Color.PINK);
		repaint();
	}
	
	public void blue(){
		graphics2D.setPaint(Color.blue.brighter());
		repaint();
	}
        
	public void green(){
		graphics2D.setPaint(Color.green.darker());
		repaint();
	}

        public void yellow() {
             graphics2D.setPaint(Color.yellow);
		repaint();
        }
        
        
        public void white() {
            graphics2D.setColor(color.white);
           graphics2D.fillOval(oldX, oldX, 50, 50);
		repaint();
        }
        
        
         public void typeString() {
             
             text=textField.getText();
             graphics2D.drawString(text,oldX,oldY);
             
		repaint();
        }
         
         public void drawFillCircle() {
             
             int z=Integer.parseInt(redius);
             int  x = oldX-(z/2);
            int y = oldY-(z/2);
            
             graphics2D.fillOval(x, y,z,z);
		repaint();
                
        }
         public void drawCircle() {
             
             int z=Integer.parseInt(redius);
          int  x = oldX-(z/2);
            int y = oldY-(z/2);
            
             graphics2D.drawOval(x, y,z, z);
		repaint();
                
        }
         
         public void drawFillRectangle() {
             
             int z=Integer.parseInt(width1);
            int z1=Integer.parseInt(length1);
            int  x = oldX-(z1/2);
            int y = oldY-(z/2);
            
             graphics2D.fillRect(x, y,z1,z);
                 repaint();
                
        }
          public void drawRectangle() {
             
             int z=Integer.parseInt(width1);
            int z1=Integer.parseInt(length1);
            int  x = oldX-(z1/2);
            int y = oldY-(z/2);
            
             graphics2D.drawRect(x, y,z1, z);
                 repaint();
                
        }
          public void drawFillEllipse() {
             
             int z=Integer.parseInt(width1);
            int z1=Integer.parseInt(length1);
            int  x = oldX-(z1/2);
            int y = oldY-(z/2);
            
             graphics2D.fillOval(x, y,z1, z);
                 repaint();
                
        } 
           public void drawEllipse() {
             
             int z=Integer.parseInt(width1);
            int z1=Integer.parseInt(length1);
            int  x = oldX-(z1/2);
            int y = oldY-(z/2);
            
             graphics2D.drawOval(x, y,z1, z);
                 repaint();
                
        }
         
         public void colorsSelect(){
             color = JColorChooser.showDialog(panel, text, Color.yellow);
             graphics2D.setColor(color);
         }
        
     

}

    
}
