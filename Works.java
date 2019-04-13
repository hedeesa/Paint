package javaapplication15;



import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class Works{
    
   Image image; 
   JFileChooser fc;
   
   public Works (Image image) {
       this.image = image;
       fc = new JFileChooser();
   }
   
    public void actionInFileIcon(JMenuItem exitItem,JMenuItem saveItem,JPanel panel){
        exitItem.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            
            System.exit(1);
        }
        });
        saveItem.addActionListener(new ActionListener(){

     
            public void actionPerformed(ActionEvent e) {
                
               /* fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fc.showSaveDialog(this);
                File file = fc.getSelectedFile();
                file = new File(file +".jpg");
                
                BufferedI
            }*/
                fc.setFileSelectionMode(
                JFileChooser.FILES_AND_DIRECTORIES);
                int result=fc.showSaveDialog(panel);
                if(result==JFileChooser.CANCEL_OPTION){
                    System.exit(1);
                }
                if(result==JFileChooser.APPROVE_OPTION){
                    
                    
                        File f=fc.getSelectedFile();
                    try {
                      //  PrintWriter out = new PrintWriter(f);
                        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
                        bufferedImage.getGraphics().drawImage(image, 0, 0, null);
                        ImageIO.write(bufferedImage, "png", f);
                        
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(makingCompliteFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Works.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        
                    
                }
                
            }
            
            
        }
        );
    }
    public void actionInEditeIcon(JMenuItem clearItem,makingCompliteFrame.PadDraw drawPad){
        clearItem.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            
            drawPad.clear();
        }
        });
    }
    public void actionClearPen(JButton clearPenButton,makingCompliteFrame.PadDraw drawPad){
        clearPenButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
                    
			drawPad.white();
                        
		}
	});
    }
    public void actionClear(JButton clearButton,makingCompliteFrame.PadDraw drawPad){
        clearButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			drawPad.clear();
		}
	});
    }
    public void actionBlack(JButton blackButton,makingCompliteFrame.PadDraw drawPad){
        blackButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
                    
                    Font font = new Font("Dialog",Font.BOLD,500);
                    drawPad.setFont(font);
			drawPad.black();
                        
		}
	});
    }
    public void actionYellow(JButton yellowButton,makingCompliteFrame.PadDraw drawPad){
        yellowButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			drawPad.yellow();
		}
	});
    }
    public void actionRed(JButton redButton,makingCompliteFrame.PadDraw drawPad){
        redButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			drawPad.red();
		}
	});
    }
    public void actionPink(JButton pinkButton,makingCompliteFrame.PadDraw drawPad){
         pinkButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			drawPad.magenta();
		}
	});
    }
    public void actionBlue(JButton blueButton,makingCompliteFrame.PadDraw drawPad){
        blueButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			drawPad.blue();
		}
	});
		
    }
    public void actionGreen(JButton greenButton,makingCompliteFrame.PadDraw drawPad){
        greenButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			drawPad.green();
		}
	});   
    }
    public void actionColor(JButton colorsButton,makingCompliteFrame.PadDraw drawPad){
        colorsButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			drawPad.colorsSelect();
		}
	});
    }
    public void actionTypeString(JButton typeString,makingCompliteFrame.PadDraw drawPad){
        typeString.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			drawPad.typeString();
		}
	});   
    }
   
    
}