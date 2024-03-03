package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.*;

import javax.swing.JPanel;
class Cood{
    int x;
    int y;
    String c;
    
}




public class GamePanel extends JPanel  implements Runnable {
    boolean isGameOver;
    final int originalTileSize=16;
    final int scale=10;
    final int tileSize=originalTileSize*scale;
    final int maxTileCol=3;
    final int maxTileRow=3;
    final int screenWidth=maxTileCol*tileSize; 
    final int screenHeight=maxTileRow*tileSize;
    KeyHandler keyHandler=new KeyHandler();
    Thread gameThread;
    
    
    
    int xi, yi;
    Cood[] cood=new Cood[9];{
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            cood[i+3*j]=new Cood();
            cood[i+3*j].x=(2*i+1)*tileSize/2;
            cood[i+3*j].y=(2*j+1)*tileSize/2;
            
            
            
            
        }
    }
       
    List<Integer> numbers = new ArrayList<>();
    for (int i = 1; i <= 9; i++) {
        numbers.add(i);
    }

    Collections.shuffle(numbers);

    for (int i=0;i<numbers.size();i++){
        if(numbers.get(i)==9){
            cood[i].c=" ";
            
            xi=cood[i].x;
            yi=cood[i].y;
        }else if(numbers.get(i)==7||numbers.get(i)==8){
            cood[i].c="$";
        }else{
            cood[i].c=numbers.get(i).toString();
        }
    
    
    }
    // xi=cood[4].x;
    // yi=cood[4].y;
    // t=4;
    
    }
    
    
    int xc=xi-(tileSize/2);
    int yc=yi-(tileSize/2);


    public GamePanel(){
        Color f=new Color(210,105,30);
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(f);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }
    public void startGameThread()
    {
        gameThread=new Thread(this);
        gameThread.start();
        isGameOver=false;
    }

    public void run(){
        while(gameThread!=null){

            update();
            repaint();
            checkGame();
            
        }
    
    }
    public void update(){
        
        if (keyHandler.up==true){
            if(yi>=3*tileSize/2){
                for(int i=0;i<9;i++){
                    if(cood[i].x==xi&&cood[i].y==yi){
                        String temp=cood[i].c;

                        cood[i].c=cood[i-3].c;
                        cood[i-3].c=temp;
                        yi=cood[i-3].y;
                        
                        break;
                    }
                }
                
            }
            keyHandler.up=false;
            
        }
        if(keyHandler.down==true){
            if(yi<=3*tileSize/2){
                for(int i=0;i<9;i++){
                    if(cood[i].x==xi&&cood[i].y==yi){
                        String temp=cood[i].c;

                        cood[i].c=cood[i+3].c;
                        cood[i+3].c=temp;
                        yi=cood[i+3].y;
                        
                        break;
                    }
                }               
                

            }
            keyHandler.down=false;
        }
        
        if(keyHandler.left==true){
            if(xi>=3*tileSize/2){
                for(int i=0;i<9;i++){
                    if(cood[i].x==xi&&cood[i].y==yi){
                        String temp=cood[i].c;

                        cood[i].c=cood[i-1].c;
                        cood[i-1].c=temp;
                        xi=cood[i-1].x;
                        
                        break;
                    }
                }
                
            }
            keyHandler.left=false;
        }
        if(keyHandler.right==true){
            if(xi<=3*tileSize/2){
                for(int i=0;i<9;i++){
                    if(cood[i].x==xi&&cood[i].y==yi){
                        String temp=cood[i].c;

                        cood[i].c=cood[i+1].c;
                        cood[i+1].c=temp;
                        xi=cood[i+1].x;
                        
                        break;
                    }
                }
                
            }
            keyHandler.right=false;
        }
            xc=xi-(tileSize/2);
            yc=yi-(tileSize/2);
        }
        public void checkGame(){
            if(!(cood[6].c.equals("$")))
            {
            return;
            }
            if(!(cood[7].c.equals("$"))){
                return;
            }
           
            for(int i=0;i<6;i++){
                
                if(!(cood[i].c.equals(String.valueOf(i+1)))){
                    return;
                }
            
            }
            isGameOver=true;
           
            
        }
        
        public void paintComponent(Graphics g){
        
            super.paintComponent(g);
            if(isGameOver){
                
                Graphics2D gresult=(Graphics2D)g;
                String re="GAME OVER!";
                Font reFont= new Font("Arial", Font.BOLD|Font.ITALIC, 30);
                gresult.setColor(Color.black);
                gresult.setFont(reFont);
                gresult.drawString(re,3*tileSize/4, tileSize );
                Graphics gCount=(Graphics2D)g;
                String count=" In "+keyHandler.keyCount+" steps";
                gCount.setColor(Color.black);
                gCount.setFont(reFont);
                gCount.drawString(count,8*tileSize/9,3*tileSize/2);
                gresult.dispose();
                gCount.dispose();
                gameThread=null;

            }else{
            Graphics2D g2=(Graphics2D)g; 
            Graphics2D g1=(Graphics2D)g;
            Graphics2D g3=(Graphics2D)g;
            Graphics2D g4=(Graphics2D)g;
            Graphics2D g5=(Graphics2D)g;
            Graphics2D g6=(Graphics2D)g;
            Graphics2D g7=(Graphics2D)g;
            Graphics2D g8=(Graphics2D)g;
            
            Graphics2D gh=(Graphics2D)g;
            
            Graphics2D b1=(Graphics2D)g; 
            Graphics2D b2=(Graphics2D)g;
            Graphics2D b3=(Graphics2D)g;
            Graphics2D b4=(Graphics2D)g;
            Graphics2D b5=(Graphics2D)g;
            Graphics2D b6=(Graphics2D)g;
            Graphics2D b7=(Graphics2D)g;
            Graphics2D b8=(Graphics2D)g;
            
            Graphics2D bh=(Graphics2D)g;
            Color col=Color.black;
            Color colb=Color.black;
            g1.setColor(col);
            
            g1.setFont(new Font("Arial", Font.BOLD, 30));
            g1.drawString(cood[0].c, cood[0].x, cood[0].y);
            g2.setColor(col);
            
            g2.setFont(new Font("Arial", Font.BOLD, 30));
            g2.drawString(cood[1].c, cood[1].x,cood[1].y );
            g3.setColor(col);
            
            g3.setFont(new Font("Arial", Font.BOLD, 30));
            g3.drawString(cood[2].c, cood[2].x,cood[2].y );
            g4.setColor(col);
            
            g4.setFont(new Font("Arial", Font.BOLD, 30));
            g4.drawString(cood[3].c, cood[3].x,cood[3].y );
            g5.setColor(col);
        
            g5.setFont(new Font("Arial", Font.BOLD, 30));
            g5.drawString(cood[5].c, cood[5].x,cood[5].y );
            g6.setColor(col);
        
            g6.setFont(new Font("Arial", Font.BOLD, 30));
            g6.drawString(cood[6].c, cood[6].x,cood[6].y );
            g7.setColor(col);
        
            g7.setFont(new Font("Arial", Font.BOLD, 30));
            g7.drawString(cood[7].c, cood[7].x,cood[7].y );
            g8.setColor(col);
        
            g8.setFont(new Font("Arial", Font.BOLD, 30));
            g8.drawString(cood[8].c, cood[8].x, cood[8].y);
            gh.setColor(col);
            
            gh.setFont(new Font("Arial", Font.BOLD, 30));
            gh.drawString(cood[4].c,cood[4].x,cood[4].y );
            gh.fillRect(xc,yc,tileSize, tileSize);
            
            b1.setColor(colb);
            b1.drawRect(cood[0].x-(tileSize/2),cood[0].y-(tileSize/2),tileSize,tileSize);
            b2.setColor(colb);
            b2.drawRect(cood[1].x-(tileSize/2),cood[1].y-(tileSize/2),tileSize,tileSize);
            b3.setColor(colb);
            b3.drawRect(cood[2].x-(tileSize/2),cood[2].y-(tileSize/2),tileSize,tileSize);
            b4.setColor(colb);
            b4.drawRect(cood[3].x-(tileSize/2),cood[3].y-(tileSize/2),tileSize,tileSize);
            b5.setColor(colb);
            b5.drawRect(cood[5].x-(tileSize/2),cood[5].y-(tileSize/2),tileSize,tileSize);
            b6.setColor(colb);
            b6.drawRect(cood[6].x-(tileSize/2),cood[6].y-(tileSize/2),tileSize,tileSize);
            b7.setColor(colb);
            b7.drawRect(cood[7].x-(tileSize/2),cood[7].y-(tileSize/2),tileSize,tileSize);
            b8.setColor(colb);
            b8.drawRect(cood[8].x-(tileSize/2),cood[8].y-(tileSize/2),tileSize,tileSize);
            bh.setColor(colb);
            bh.drawRect(cood[4].x-(tileSize/2),cood[4].y-(tileSize/2),tileSize,tileSize);
            
            
            g1.dispose();
            g2.dispose();
            g3.dispose();
            g4.dispose();
            g5.dispose();
            g6.dispose();
            g7.dispose();
            g8.dispose();
            gh.dispose();
            b1.dispose();
            b2.dispose();
            b3.dispose();
            b4.dispose();
            b5.dispose();
            b6.dispose();
            b7.dispose();
            b8.dispose();
            bh.dispose();
            
            }
            


    
    }
}    


