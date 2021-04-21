import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.lang.Math.sqrt;

public class MyPanel extends JPanel implements KeyEventDispatcher {
    BufferedImage doom;
    BufferedImage doom2;
    BufferedImage mon1;
    BufferedImage mon12;
    BufferedImage mon2;
    BufferedImage mon22;
    BufferedImage mon3;
    BufferedImage mon32;
    BufferedImage mon4;
    BufferedImage mon42;
    BufferedImage hp;
    BufferedImage shield;
    BufferedImage ar;
    BufferedImage back;
    BufferedImage am10;
    BufferedImage am7;
    BufferedImage am3;
    BufferedImage am;
    BufferedImage el1;
    BufferedImage el2;
    BufferedImage el3;
    BufferedImage el4;
    BufferedImage boss;
    BufferedImage shadow;
    BufferedImage background;
    BufferedImage pause;
    int chx=0;int chx1=0;int chx2=0;int chx3=0;int chx4=0;// смещение по x объектов и пуль
    int chy=0;int chy1=0;int chy2=0;int chy3=0;int chy4=0;// смещение по y объектов и пуль

    double d1; double d2; double d12; double d22;double d13; double d23;double d14; double d24;double d1min; double d2min;double d1boss; double d2boss;//передвижение врагов
    int x1=910;int y1=455;//координаты игрока
    int xsh=1980;//координаты щита
    int arl=-1;//проверка поднятия брони
    int monl=-1;//проверка соприкосновения со врагом
    int x=0; int y=0;//смещение объекddтов при движении игрока
    double d=0.0;// поворот игрока
    int monster4=0;int miniboss=0; int bboss=0;//счетчик попаданий
    int spsw=40;//энергия шокера
    int xm=-100;int ym=-100;    int xm2=1920;int ym2=-100;    int xm3=-100;int ym3=1050;    int xm4=1920;int ym4=1050;    int xmin=1200;int ymin=500;   int xboss=10000;int yboss=10000;//координаты врагов
    int m=4;    int l=-1;    int l1=-1;    int l2=-1;    int l3=-1;    int l4=-1;//счетчики для пуль
    int xs1=910; int ys1=475;int xs2=910; int ys2=475;int xs3=910; int ys3=475;int xs4=910; int ys4=475;//координаты пуль
    int xs11=0; int ys11=0;int xs22=0; int ys22=0;int xs33=0; int ys33=0;int xs44=0; int ys44=0;//смещение координат пуль
    int sp1=0;int sp2=0;int sp3=0;int sp4=0;//скорость полета пуль
    int hpx1=1800; int hpy1=20;int hpx2=1740; int hpy2=20; int arx1=1800;  int ary1=80;int arx2=1740; int ary2=80;//координаты жизней и брони
    int xh1=200; int yh1=200;//координаты подмираемой брони
    int a; int b; int c; int dd; //рандомное появление врагов
    int stop=0;//пауза
    long prevTime;//время
    int kill=0;//счетчик убийств
    int amml=0;int amml2=0;int amml3=0;//проверка подбирания патронов
    int lam=0;int lam2=0; int lam3=0; int lam4=0;
    int ammo=10;//количество пуль
    int xam1=100000; int yam1=100000;//координаты пачки 10 пуль
    int xam2=100000; int yam2=100000;//координаты пачки 7 пуль
    int xam3=800; int yam3=800;//координаты пачки 3 пуль
    int plumpy1=0;int plumpy2=0;int plumpy3=0;int plumpy4=0;int plumpymin=0; int facemin=0;//изменение облика врагов
    int plump1=0;int plump2=0;int plump3=0;int plump4=0; int plumpmin=0; int hero=0;//счетчики изменнения облика игрока и врагов
    int minl=0; int bossl=0;//счетчики появления минибосса и босса
    int sw=0;
    int sl=-1;
    int swl=-1;
    int swx1=10000; int swy1=10000;int swx2=10000; int swy2=10000;int swx3=10000; int swy3=10000;int swx4=10000; int swy4=10000;//координаты шокера
    int swes1=0;int swes2=0;int swes3=0;int swes4=0;
    int lagx;




public MyPanel(){
    KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
    manager.addKeyEventDispatcher(this);
    System.out.println("add");
    prevTime = System.currentTimeMillis();
}

    public void  unicornImage() throws IOException {
        this.doom = ImageIO.read(new File("C:\\Users\\scheglovai.22\\Downloads\\doom.png"));//you
        this.doom2 = ImageIO.read(new File("C:\\Users\\scheglovai.22\\Downloads\\doom(2).png"));//you
        this.mon1 = ImageIO.read(new File("C:\\Users\\scheglovai.22\\Downloads\\mon1.png"));//1mon
        this.mon12 = ImageIO.read(new File("C:\\Users\\scheglovai.22\\Downloads\\mon1(2).png"));//1mon
        this.mon2 = ImageIO.read(new File("C:\\Users\\scheglovai.22\\Downloads\\mon2.png"));//2mon
        this.mon22 = ImageIO.read(new File("C:\\Users\\scheglovai.22\\Downloads\\mon2(2).png"));//2mon
        this.mon3 = ImageIO.read(new File("C:\\Users\\scheglovai.22\\Downloads\\mon3.png"));//2mon
        this.mon32 = ImageIO.read(new File("C:\\Users\\scheglovai.22\\Downloads\\mon3(2).png"));//2mon
        this.mon4 = ImageIO.read(new File("C:\\Users\\scheglovai.22\\Downloads\\mon4.png"));//2mon
        this.mon42 = ImageIO.read(new File("C:\\Users\\scheglovai.22\\Downloads\\mon4(2).png"));//2mon
        this.hp = ImageIO.read(new File("C:\\Users\\scheglovai.22\\Downloads\\hp.png"));//hp
        this.ar = ImageIO.read(new File("C:\\Users\\scheglovai.22\\Downloads\\ar.png"));//armor
        this.am10 = ImageIO.read(new File("C:\\Users\\scheglovai.22\\Downloads\\am10.png"));//patrons
        this.am7 = ImageIO.read(new File("C:\\Users\\scheglovai.22\\Downloads\\am7.png"));//patrons
        this.am3 = ImageIO.read(new File("C:\\Users\\scheglovai.22\\Downloads\\am3.png"));//patrons
        this.am = ImageIO.read(new File("C:\\Users\\scheglovai.22\\Downloads\\am.png"));//patrons
        this.back = ImageIO.read(new File("C:\\Users\\scheglovai.22\\Downloads\\back.png"));//ecran
        this.shield = ImageIO.read(new File("C:\\Users\\scheglovai.22\\Downloads\\shield.png"));//ecran
        this.el1 = ImageIO.read(new File("C:\\Users\\scheglovai.22\\Downloads\\el1.png"));//patrons
        this.el2 = ImageIO.read(new File("C:\\Users\\scheglovai.22\\Downloads\\el2.png"));//patrons
        this.el3 = ImageIO.read(new File("C:\\Users\\scheglovai.22\\Downloads\\el3.png"));//patrons
        this.el4 = ImageIO.read(new File("C:\\Users\\scheglovai.22\\Downloads\\el4.png"));//patrons
        this.boss = ImageIO.read(new File("C:\\Users\\scheglovai.22\\Downloads\\boss.png"));//patrons
        this.shadow = ImageIO.read(new File("C:\\Users\\scheglovai.22\\Downloads\\shadow.png"));//patrons
        this.background = ImageIO.read(new File("C:\\Users\\scheglovai.22\\Downloads\\background.png"));//patrons
        this.pause = ImageIO.read(new File("C:\\Users\\scheglovai.22\\Downloads\\pause.png"));//patrons
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        long curTime = System.currentTimeMillis();
        double dt = (curTime - prevTime) / 16.5;
        prevTime = curTime;

        if(bossl==0){xboss=885-x; yboss=-200-y;}

        if (kill % 10==0 && kill!=0){minl=1;}
        if (kill % 19==0 && kill!=0){bossl=1; minl=0;}
        if (bossl!=0){minl=0;}
        if (minl==0){miniboss=0;}

        plumpmin=plumpmin+1;
        if (stop==0 && plumpmin<=13 && plumpmin>=7){plumpymin=plumpymin+1;}
        if (stop==0 && plumpmin>13){plumpymin=plumpymin-1;}
        if (stop!=0 && plumpmin<=13 && plumpmin>=7){plumpymin=plumpymin;}
        if (stop!=0 && plumpmin>13){plumpymin=plumpymin;}
        if (plumpmin==19){plumpmin=7;}

        if (spsw==30){swl=0;}
        if (spsw==0){swl=-1;}
        if(sl==-1 && stop==0){spsw=spsw+1;}
        if (spsw>=30){spsw=30;}

        lagx= (int) (Math.random()*3);


        double angleInDegrees = d; // Угол поворота в градусах
        double angleInRadians = Math.toRadians(angleInDegrees);
        double locationX = doom.getWidth() / 2;
        double locationY = doom.getHeight() / 2;
        AffineTransform tx = AffineTransform.getRotateInstance(angleInRadians, locationX, locationY);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        for(int iy=-100000; iy<=100000; iy+=1000){
        for(int ix=-100000; ix<=100000; ix+=1000){g.drawImage(background,ix+ x,iy+ y, 1000, 1000, null);}}       g.drawImage(ar, xh1 + x, yh1 + y, 50, 50, null);
        g.drawImage(am10, xam1 + x, yam1 + y, 50, 50, null);
        g.drawImage(am7, xam2 + x, yam2 + y, 50, 50, null);
        g.drawImage(am3, xam3 + x, yam3 + y, 50, 50, null);
        g.setColor(new Color(16, 28, 4));
        if (hpx1==1950 && (monl==3 || monl==2)){xsh=x1-5;
        }else{xsh=1980;}
        if (xh1 + x + 50 < x1 || xh1 + x > x1 + 50+40 || yh1 + y + 50 < y1 || yh1 + y > y1 + 50+40) {
        arl=-1;
        }

        if (xh1 + x + 50 >= x1 && xh1 + x <= x1 + 50+40 && yh1 + y + 50 >= y1 && yh1 + y <= y1 + 50+40) {//+ar
            xh1=(int) (Math.random()*1600)+100;
            yh1=(int) (Math.random()*700)+100;
        if (arx2==1950 && arx1==1950){
            arx2=1740;
            monl=1;
            arl=0;
        }
            if (arx2==1740 && arx1==1950 && arl==-1){
                arx1=1800;
                monl=-1;
            }

        }
        if (xam1 + x + 50 >= x1 && xam1 + x <= x1 + 50+40 && yam1 + y + 50 >= y1 && yam1 + y <= y1 + 50+40 && amml==0 ) {//+
            if(ammo+10>25){ammo=25;}
            else ammo=ammo+10;
            amml=1;
            xam1=100000;
            yam1=100000;
        }
        if (ammo<0){ammo=0;}
        if (xam1 + x + 50 < x1 || xam1 + x > x1 + 50+40 || yam1 + y + 50 < y1 || yam1 + y > y1 + 50+40) {//+
            amml=0;
        }
        if (xam2 + x + 50 >= x1 && xam2 + x <= x1 + 50+40 && yam2 + y + 50 >= y1 && yam2 + y <= y1 + 50+40 && amml2==0 ) {//+
            if(ammo+7>25){ammo=25;}
            else ammo=ammo+7;
            amml2=1;
            xam2=100000;
            yam2=100000;
        }
        if (xam2 + x + 50 < x1 || xam2 + x > x1 + 50+40 || yam2 + y + 50 < y1 || yam2 + y > y1 + 50+40) {//+
            amml2=0;}

        if (xam3 + x + 50 >= x1 && xam3 + x <= x1 + 50+40 && yam3 + y + 50 >= y1 && yam3 + y <= y1 + 50+40 && amml3==0 ) {//+
            if(ammo+3>25){ammo=25;}
            else ammo=ammo+3;
            amml3=1;
            xam3=(int) (Math.random()*1600)+100;
            yam3=(int) (Math.random()*700)+100;
        }
        if (xam3 + x + 50 < x1 || xam3 + x > x1 + 50+40 || yam3 + y + 50 < y1 || yam3 + y > y1 + 50+40) {//+
            amml3=0;}

        if(xm<-120-x){xm=1940-x;}
        if(xm>1940-x){xm=-120-x;}
        if(ym<-120-y){ym=1070-y;}
        if(ym>1070-y){ym=-120-y;}

        if(xm2<-120-x){xm2=1940-x;}
        if(xm2>1940-x){xm2=-120-x;}
        if(ym2<-120-y){ym2=1070-y;}
        if(ym2>1070-y){ym2=-120-y;}

        if(xm3<-120-x){xm3=1940-x;}
        if(xm3>1940-x){xm3=-120-x;}
        if(ym3<-120-y){ym3=1070-y;}
        if(ym3>1070-y){ym3=-120-y;}

        if(xm4<-120-x){xm4=1940-x;}
        if(xm4>1940-x){xm4=-120-x;}
        if(ym4<-120-y){ym4=1070-y;}
        if(ym4>1070-y){ym4=-120-y;}
     if(minl==1){
        if(xmin<-170-x){xmin=1990-x;}
        if(xmin>1990-x){xmin=-170-x;}
        if(ymin<-170-y){ymin=1120-y;}
        if(ymin>1120-y){ymin=-170-y;}}
     if(bossl==1){
        if(xboss<-220-x){xboss=2040-x;}
        if(xboss>2040-x){xboss=-220-x;}
        if(yboss<-220-y){yboss=1170-y;}
        if(yboss>1170-y){yboss=-220-y;}}


        double deltaXboss = x1-x+50 - xboss-100;
        double deltaYboss = y1-y+50 - yboss-100;

        double lengthDeltaboss = sqrt(deltaXboss * deltaXboss + deltaYboss * deltaYboss+1);
        d1boss = deltaXboss*7.0 / lengthDeltaboss;
        d2boss = deltaYboss*7.0 / lengthDeltaboss;
        if (bossl==1 && lagx==2 && stop==0) {
            xboss = (int) (xboss + d1boss*dt);
            yboss = (int) (yboss + d2boss*dt);
        } else if( bossl==1) {xboss=xboss;yboss=yboss;}
        else if(lagx!=2 && bossl==1){xboss=xboss;yboss=yboss;}
        else  {xboss = 885-x; yboss=-200 -y;}

            double deltaX = x1-x+50 - xm-50;
        double deltaY = y1-y+50 - ym-50;

        double lengthDelta = sqrt(deltaX * deltaX + deltaY * deltaY+1);
        d1 = deltaX*2.1 / lengthDelta;
        d2 = deltaY*2.1 / lengthDelta;
        if (stop==0) {
            xm = (int) (xm + d1*dt);
            ym = (int) (ym + d2*dt);
        }

        double deltaX3 = x1-x+50 - xm3-50;
        double deltaY3= y1-y+50 - ym3-50;

        double lengthDelta3 = sqrt(deltaX3 * deltaX3 + deltaY3 * deltaY3+1);
        d13 = deltaX3*2.1 / lengthDelta3;
        d23 = deltaY3*2.1 / lengthDelta3;
        if (stop==0) {
            xm3 = (int) (xm3 + d13*dt);
            ym3 = (int) (ym3 + d23*dt);
        }
        double deltaX4 = x1-x+50 - xm4-50;
        double deltaY4= y1-y+50 - ym4-50;

        double lengthDelta4 = sqrt(deltaX4 * deltaX4 + deltaY4 * deltaY4+1);
        d14 = deltaX4*2.3 / lengthDelta4;
        d24 = deltaY4*2.3 / lengthDelta4;
        if (stop==0 ) {
            xm4 = (int) (xm4 + d14*dt);
            ym4 = (int) (ym4 + d24*dt);
        }
        if (bossl!=0){xm4=1920-x;ym4=1050-y;}

        double deltaX2 = x1-x+50 - xm2-50;
        double deltaY2 = y1-y+50 - ym2-50;

        double lengthDelta2 = sqrt(deltaX2 * deltaX2 + deltaY2 * deltaY2+1);
        d12 = deltaX2*3.0 / lengthDelta2;
        d22 = deltaY2*3.0 / lengthDelta2;
        if (stop==0) {
            xm2 = (int) (xm2 + d12*dt);
            ym2 = (int) (ym2 + d22*dt);
        }
        if (bossl!=0){xm2=1920-x; ym2=-100-y;}

        double deltaXmin = x1-x+50 - xmin-75;
        double deltaYmin = y1-y+50 - ymin-75;

        double lengthDeltamin = sqrt(deltaXmin * deltaXmin + deltaYmin * deltaYmin+1);
        d1min = deltaXmin*2.1 / lengthDeltamin;
        d2min = deltaYmin*2.1 / lengthDeltamin;
        if (stop==0 && minl==1) {
            xmin = (int) (xmin + d1min*dt);
            ymin = (int) (ymin + d2min*dt);
        } else if(stop==1 && minl==1) {xmin=xmin;ymin=ymin;}
        else {xmin = 885-x; ymin= -200 -y;}

        if ((xm + x + 100 < x1 || xm + x > x1 + 100 || ym + y + 100 < y1 || ym + y > y1 + 100) && (xm2 + x + 100 < x1 || xm2 + x > x1 + 100 || ym2 + y + 100 < y1 || ym2 + y > y1 +100) && (xm3 + x + 100 < x1 || xm3 + x > x1 + 100 || ym3 + y + 100 < y1 || ym3 + y > y1 + 100)&& (xm4 + x + 100 < x1 || xm4 + x > x1 + 100 || ym4 + y + 100 < y1 || ym4 + y > y1 + 100)&& (xmin + x + 150 < x1 || xmin + x > x1 + 100 || ymin + y + 150 < y1 || ymin + y > y1 + 100) && (xboss + x +200  < x1 || xboss + x  > x1 +150 || yboss + y + 200 < y1 || yboss + y > y1 + 150)) {
           if (monl==0){ monl = 1;}
            if (monl==2){ monl = 3;}
            if (monl==4){ monl = 5;}
        }
        if ((xm + x + 80 >= x1 && xm + x <= x1 + 80 && ym + y + 80 >= y1 && ym + y <= y1 + 80)||(xm2 + x + 70 >= x1 && xm2 + x <= x1 + 70 && ym2 + y + 70 >= y1 && ym2 + y <= y1 + 7d)||(xm3 + x + 80 >= x1 && xm3 + x <= x1 + 80 && ym3 + y + 80 >= y1 && ym3 + y <= y1 + 80)||(xm4 + x + 80 >= x1 && xm4 + x <= x1 + 80 && ym4 + y + 80 >= y1 && ym4 + y <= y1 + 80)||(xmin + x +130  >= x1 && xmin + x  <= x1 +80 && ymin + y + 130 >= y1 && ymin + y <= y1 + 80) || (xboss + x +160  >= x1 && xboss + x  <= x1 +50 && yboss + y + 160 >= y1 && yboss + y <= y1 + 50)  ) {//-hp
            if (arx1 == 1800) {
                arx1 = 1950;
                monl=0;
            }
            if (arx1 == 1950 && monl == 1) {
                arx2 = 1950;
                monl=2;
            }
            if (arx2 == 1950 && monl == 3) {
                hpx1 = 1950;
                monl=4;
            }
            if (hpx1 == 1950 && monl == 5) {
                hpx2 = 1950;
            }

        }

        if(swx4==10000 && swy4==10000){swes4=0;}
        if(swx3==10000 && swy3==10000){swes3=0;}
        if(swx2==10000 && swy2==10000){swes2=0;}
        if(swx1==10000 && swy1==10000){swes1=0;}
//----------------------------------------------------------
        if (d==0.0 && sl==0 && swl == 0 && stop==0) {
                spsw=spsw-1;
                swx4 = 948;
                swy4 = 555;
        }else{if(stop==0){swx4 = 10000;swy4 = 10000;}}
        if(swx4 + 25 >= xm+x && swx4  <= xm+x + 100 && swy4 + 100 >= ym+y && swy4 <= ym+y + 100 && swes4==0 && stop==0){swes4=1;kill=kill+1;a= (int) (Math.random()*4);
            if (a==0){xm=-100-x; ym=-100-y;}
            if (a==1){xm=1920-x; ym=-100-y;}
            if (a==2){xm=-100-x; ym=1050-y;}
            if (a==3){xm=1920-x; ym=1050-y;}}
        if(swx4 + 25 >= xm3+x && swx4  <= xm3+x + 100 && swy4 + 100 >= ym3+y && swy4 <= ym3+y + 100 && swes4==0 && stop==0){swes4=1;kill=kill+1;c= (int) (Math.random()*4);
            if (c==0){xm3=-100-x; ym3=-100-y;}
            if (c==1){xm3=1920-x; ym3=-100-y;}
            if (c==2){xm3=-100-x; ym3=1050-y;}
            if (c==3){xm3=1920-x; ym3=1050-y;}}
        if(swx4 + 25 >= xm2+x && swx4  <= xm2+x + 100 && swy4 + 100 >= ym2+y && swy4 <= ym2+y + 100 && swes4==0 && stop==0){swes4=1;kill=kill+1;b= (int) (Math.random()*4);
            if (b==0){xm2=-100-x; ym2=-100-y;}
            if (b==1){xm2=1920-x; ym2=-100-y;}
            if (b==2){xm2=-100-x; ym2=1050-y;}
            if (b==3){xm2=1920-x; ym2=1050-y;}}
        if(swx4 + 25 >= xm4+x && swx4  <= xm4+x + 100 && swy4 + 100 >= ym4+y && swy4 <= ym4+y + 100 && swes4==0 && stop==0){swes4=1;monster4=monster4+1;if (monster4==2){dd= (int) (Math.random()*4);
            xam3=xm4;
            yam3=ym4;
            if (dd==0){xm4=-100-x; ym4=-100-y;}
            if (dd==1){xm4=1920-x; ym4=-100-y;}
            if (dd==2){xm4=-100-x; ym4=1050-y;}
            if (dd==3){xm4=1920-x; ym4=1050-y;}
            monster4=0;
            kill=kill+1;}}
        if(swx4 + 25 >= xmin+x && swx4  <= xmin+x + 150 && swy4 + 100 >= ymin+y && swy4 <= ymin+y + 150 && swes4==0 && stop==0){swes4=1;miniboss=miniboss+1;if (miniboss==4){xam2=xmin;
            yam2=ymin;
            xh1=xmin+100;
            yh1=ymin;
            miniboss=0;
            kill=kill+1;
            minl=0;}}
        if(swx4 + 25 >= xboss+x && swx4  <= xboss+x + 200 && swy4 + 100 >= yboss+y && swy4 <= yboss+y + 200 && swes4==0 && stop==0){swes4=1;bboss=bboss+1;if (bboss==5){
            xam1=xboss;
            yam1=yboss;
            xh1=xboss+100;
            yh1=yboss;
            bboss=0;
            kill=kill+1;
            bossl=0;}}
//-----------------------------------------------------------------
        if (d==180.0 && sl==0 && swl == 0 && stop==0) {
            spsw=spsw-1;
            swx1 = 948;
            swy1 = 355;
        }else{if(stop==0){swx1 = 10000;swy1 = 10000;}}
        if(swx1 + 25 >= xm+x && swx1  <= xm+x + 100 && swy1 + 100 >= ym+y && swy1 <= ym+y + 100  && swes1==0 && stop==0){ swes1=1;kill=kill+1;a= (int) (Math.random()*4);
            if (a==0){xm=-100-x; ym=-100-y;}
            if (a==1){xm=1920-x; ym=-100-y;}
            if (a==2){xm=-100-x; ym=1050-y;}
            if (a==3){xm=1920-x; ym=1050-y;}}
        if(swx1 + 25 >= xm3+x && swx1  <= xm3+x + 100 && swy1 + 100 >= ym3+y && swy1 <= ym3+y + 100&& swes1==0 && stop==0){ swes1=1;kill=kill+1;c= (int) (Math.random()*4);
            if (c==0){xm3=-100-x; ym3=-100-y;}
            if (c==1){xm3=1920-x; ym3=-100-y;}
            if (c==2){xm3=-100-x; ym3=1050-y;}
            if (c==3){xm3=1920-x; ym3=1050-y;}}
        if(swx1 + 25 >= xm2+x && swx1  <= xm2+x + 100 && swy1 + 100 >= ym2+y && swy1 <= ym2+y + 100&& swes1==0 && stop==0){ swes1=1;kill=kill+1;b= (int) (Math.random()*4);
            if (b==0){xm2=-100-x; ym2=-100-y;}
            if (b==1){xm2=1920-x; ym2=-100-y;}
            if (b==2){xm2=-100-x; ym2=1050-y;}
            if (b==3){xm2=1920-x; ym2=1050-y;}}
        if(swx1 + 25 >= xm4+x && swx1  <= xm4+x + 100 && swy1 + 100 >= ym4+y && swy1 <= ym4+y + 100 && swes1==0 && stop==0){swes1=1;monster4=monster4+1;if (monster4==2){dd= (int) (Math.random()*4);
            xam3=xm4;
            yam3=ym4;
            if (dd==0){xm4=-100-x; ym4=-100-y;}
            if (dd==1){xm4=1920-x; ym4=-100-y;}
            if (dd==2){xm4=-100-x; ym4=1050-y;}
            if (dd==3){xm4=1920-x; ym4=1050-y;}
            monster4=0;
            kill=kill+1;}}
        if(swx1 + 25 >= xmin+x && swx1  <= xmin+x + 150 && swy1 + 100 >= ymin+y && swy1 <= ymin+y + 150 && swes1==0 && stop==0){swes1=1;miniboss=miniboss+1;if (miniboss==4){xam2=xmin;
            yam2=ymin;
            xh1=xmin+100;
            yh1=ymin;
            miniboss=0;
            kill=kill+1;
            minl=0;}}
        if(swx1 + 25 >= xboss+x && swx1  <= xboss+x + 200 && swy1 + 100 >= yboss+y && swy1 <= yboss+y + 200 && swes1==0 && stop==0){swes1=1;bboss=bboss+1;if (bboss==5){
            xam1=xboss;
            yam1=yboss;
            xh1=xboss+100;
            yh1=yboss;
            bboss=0;
            kill=kill+1;
            bossl=0;}}
//---------------------------------------------------------------------
        if (d==270.0 && sl==0 && swl == 0 && stop==0) {
            spsw=spsw-1;
            swx3 = 1010;
            swy3 = 493;
        }else{if(stop==0){swx3 = 10000;swy3 = 10000;}}
        if(swx3 + 100 >= xm+x && swx3  <= xm+x + 100 && swy3 + 25 >= ym+y && swy3 <= ym+y + 100&& swes3==0 && stop==0){swes3=1;kill=kill+1;a= (int) (Math.random()*4);
            if (a==0){xm=-100-x; ym=-100-y;}
            if (a==1){xm=1920-x; ym=-100-y;}
            if (a==2){xm=-100-x; ym=1050-y;}
            if (a==3){xm=1920-x; ym=1050-y;}}
        if(swx3 + 100 >= xm3+x && swx3  <= xm3+x + 100 && swy3 + 25 >= ym3+y && swy3 <= ym3+y + 100&& swes3==0 && stop==0){swes3=1;kill=kill+1;c= (int) (Math.random()*4);
            if (c==0){xm3=-100-x; ym3=-100-y;}
            if (c==1){xm3=1920-x; ym3=-100-y;}
            if (c==2){xm3=-100-x; ym3=1050-y;}
            if (c==3){xm3=1920-x; ym3=1050-y;}}
        if(swx3 + 100 >= xm2+x && swx3  <= xm2+x + 100 && swy3 + 25 >= ym2+y && swy3 <= ym2+y + 100&& swes3==0 && stop==0){swes3=1;kill=kill+1;b= (int) (Math.random()*4);
            if (b==0){xm2=-100-x; ym2=-100-y;}
            if (b==1){xm2=1920-x; ym2=-100-y;}
            if (b==2){xm2=-100-x; ym2=1050-y;}
            if (b==3){xm2=1920-x; ym2=1050-y;}}
        if(swx3 + 100 >= xm4+x && swx3  <= xm4+x + 100 && swy3 + 25 >= ym4+y && swy3 <= ym4+y + 100 && swes3==0 && stop==0){swes3=1;monster4=monster4+1;if (monster4==2){dd= (int) (Math.random()*4);
            xam3=xm4;
            yam3=ym4;
            if (dd==0){xm4=-100-x; ym4=-100-y;}
            if (dd==1){xm4=1920-x; ym4=-100-y;}
            if (dd==2){xm4=-100-x; ym4=1050-y;}
            if (dd==3){xm4=1920-x; ym4=1050-y;}
            monster4=0;
            kill=kill+1;}}
        if(swx3 + 100 >= xmin+x && swx3  <= xmin+x + 150 && swy3 + 25 >= ymin+y && swy3 <= ymin+y + 150 && swes3==0 && stop==0){swes3=1;miniboss=miniboss+1;if (miniboss==4){xam2=xmin;
            yam2=ymin;
            xh1=xmin+100;
            yh1=ymin;
            miniboss=0;
            kill=kill+1;
            minl=0;}}
        if(swx3 + 100 >= xboss+x && swx3  <= xboss+x + 200 && swy3 + 25 >= yboss+y && swy3 <= yboss+y + 200 && swes3==0 && stop==0){swes3=1;bboss=bboss+1;if (bboss==5){
            xam1=xboss;
            yam1=yboss;
            xh1=xboss+100;
            yh1=yboss;
            bboss=0;
            kill=kill+1;
            bossl=0;}}
//------------------------------------------------------------------
        if (d==90.0 && sl==0 && swl == 0 && stop==0) {
            spsw=spsw-1;
            swx2 = 810;
            swy2 = 493;
        }else{ if(stop==0){swx2 = 10000;swy2 = 10000;}}
        if(swx2 + 100 >= xm+x && swx2  <= xm+x + 100 && swy2 + 25 >= ym+y && swy2 <= ym+y + 100&& swes2==0 && stop==0){swes2=1;kill=kill+1;a= (int) (Math.random()*4);
            if (a==0){xm=-100-x; ym=-100-y;}
            if (a==1){xm=1920-x; ym=-100-y;}
            if (a==2){xm=-100-x; ym=1050-y;}
            if (a==3){xm=1920-x; ym=1050-y;}}
        if(swx2 + 100 >= xm3+x && swx2  <= xm3+x + 100 && swy2 + 25 >= ym3+y && swy2 <= ym3+y + 100&& swes2==0 && stop==0){swes2=1;kill=kill+1;c= (int) (Math.random()*4);
            if (c==0){xm3=-100-x; ym3=-100-y;}
            if (c==1){xm3=1920-x; ym3=-100-y;}
            if (c==2){xm3=-100-x; ym3=1050-y;}
            if (c==3){xm3=1920-x; ym3=1050-y;}}
        if(swx2 + 100 >= xm2+x && swx2  <= xm2+x + 100 && swy2 + 25 >= ym2+y && swy2 <= ym2+y + 100&& swes2==0 && stop==0){swes2=1;kill=kill+1;b= (int) (Math.random()*4);
            if (b==0){xm2=-100-x; ym2=-100-y;}
            if (b==1){xm2=1920-x; ym2=-100-y;}
            if (b==2){xm2=-100-x; ym2=1050-y;}
            if (b==3){xm2=1920-x; ym2=1050-y;}}
        if(swx2 + 100 >= xm4+x && swx2  <= xm4+x + 100 && swy2 + 25 >= ym4+y && swy2 <= ym4+y + 100 && swes2==0 && stop==0){swes2=1;monster4=monster4+1;if (monster4==2){dd= (int) (Math.random()*4);
            xam3=xm4;
            yam3=ym4;
            if (dd==0){xm4=-100-x; ym4=-100-y;}
            if (dd==1){xm4=1920-x; ym4=-100-y;}
            if (dd==2){xm4=-100-x; ym4=1050-y;}
            if (dd==3){xm4=1920-x; ym4=1050-y;}
            monster4=0;
            kill=kill+1;}}
        if(swx2 + 100 >= xmin+x && swx2  <= xmin+x + 150 && swy2 + 25 >= ymin+y && swy2 <= ymin+y + 150 && swes2==0 && stop==0){swes2=1;miniboss=miniboss+1;if (miniboss==4){xam2=xmin;
            yam2=ymin;
            xh1=xmin+100;
            yh1=ymin;
            miniboss=0;
            kill=kill+1;
            minl=0;}}
        if(swx2 + 100 >= xboss+x && swx2  <= xboss+x + 200 && swy2 + 25 >= yboss+y && swy2 <= yboss+y + 200 && swes2==0 && stop==0){swes2=1;bboss=bboss+1;if (bboss==5){
            xam1=xboss;
            yam1=yboss;
            xh1=xboss+100;
            yh1=yboss;
            bboss=0;
            kill=kill+1;
            bossl=0;}}

 //------------------------------------------------------------

             if (m == 4 && l == 0 && ammo>0) {
                l4 = 0;
                l = -1;
                 if(lam4==0){ammo=ammo-1;}
            }
            if (l4 == 0 ) {//up
                if(stop==0){sp4 = sp4 + 10;}
                if(stop!=0){sp4 = sp4;}
                g.fillOval(xs4 + 40 + xs44, ys4 + sp4 + 40 + ys44, 20, 20);
                lam4=1;
                if (ys4 + sp4 + ys44 >= 1050) {
                    lam4=0;
                    sp4 = 0;
                    l = -1;
                    l4 = -1;
                    xs44 = 0;
                    ys44 = 0;
                    xs4 = 910;
                    ys4 = 475;


                }
                if  (ys4 + sp4 + 60 + ys44 >= ym + y && ys4 + sp4 + 40 + ys44 <= ym + y + 100 && xs4 + 40 + xs44 <= xm + x + 100 && xs4 + 40 + xs44 >= xm + x) {
                    sp4 = 0;
                    l = -1;
                    l4 = -1;
                    xs4 = 910;
                    ys4 = 475;
                    xs44 = 0;
                    ys44 = 0;
                    a= (int) (Math.random()*4);
                    if (a==0){xm=-100-x; ym=-100-y;}
                    if (a==1){xm=1920-x; ym=-100-y;}
                    if (a==2){xm=-100-x; ym=1050-y;}
                    if (a==3){xm=1920-x; ym=1050-y;}
                    kill=kill+1;
                    lam4=0;
                }
                if  (ys4 + sp4 + 60 + ys44 >= ym3 + y && ys4 + sp4 + 40 + ys44 <= ym3 + y + 100 && xs4 + 40 + xs44 <= xm3 + x + 100 && xs4 + 40 + xs44 >= xm3 + x) {
                    sp4 = 0;
                    l = -1;
                    l4 = -1;
                    xs4 = 910;
                    ys4 = 475;
                    xs44 = 0;
                    ys44 = 0;
                    c= (int) (Math.random()*4);
                    if (c==0){xm3=-100-x; ym3=-100-y;}
                    if (c==1){xm3=1920-x; ym3=-100-y;}
                    if (c==2){xm3=-100-x; ym3=1050-y;}
                    if (c==3){xm3=1920-x; ym3=1050-y;}
                    kill=kill+1;
                    lam4=0;
                }
                if  (ys4 + sp4 + 60 + ys44 >= ym2 + y && ys4 + sp4 + 40 + ys44 <= ym2 + y + 100 && xs4 + 40 + xs44 <= xm2 + x + 100 && xs4 + 40 + xs44 >= xm2 + x) {
                    sp4 = 0;
                    l = -1;
                    l4 = -1;
                    xs4 = 910;
                    ys4 = 475;
                    xs44 = 0;
                    ys44 = 0;
                    b= (int) (Math.random()*4);
                    if (b==0){xm2=-100-x; ym2=-100-y;}
                    if (b==1){xm2=1920-x; ym2=-100-y;}
                    if (b==2){xm2=-100-x; ym2=1050-y;}
                    if (b==3){xm2=1920-x; ym2=1050-y;}
                    kill=kill+1;
                    lam4=0;
                }
                if  (ys4 + sp4 + 60 + ys44 >= ym4 + y && ys4 + sp4 + 40 + ys44 <= ym4 + y + 100 && xs4 + 40 + xs44 <= xm4 + x + 100 && xs4 + 40 + xs44 >= xm4 + x) {
                    sp4 = 0;
                    l = -1;
                    l4 = -1;
                    xs4 = 910;
                    ys4 = 475;
                    xs44 = 0;
                    ys44 = 0;
                    monster4=monster4+1;
                    if (monster4==2){
                        xam3=xm4;
                        yam3=ym4;
                        dd= (int) (Math.random()*4);
                    if (dd==0){xm4=-100-x; ym4=-100-y;}
                    if (dd==1){xm4=1920-x; ym4=-100-y;}
                    if (dd==2){xm4=-100-x; ym4=1050-y;}
                    if (dd==3){xm4=1920-x; ym4=1050-y;}
                    monster4=0;
                        kill=kill+1;
                        lam4=0;
                    }
                }
                if  (ys4 + sp4 + 60 + ys44 >= ymin + y && ys4 + sp4 + 40 + ys44 <= ymin + y + 150 && xs4 + 40 + xs44 <= xmin + x + 150 && xs4 + 40 + xs44 >= xmin + x) {
                    sp4 = 0;
                    l = -1;
                    l4 = -1;
                    xs4 = 910;
                    ys4 = 475;
                    xs44 = 0;
                    ys44 = 0;
                    miniboss=miniboss+1;
                    if (miniboss==4){
                        xam2=xmin;
                        yam2=ymin;
                        xh1=xmin+100;
                        yh1=ymin;
                        miniboss=0;
                        kill=kill+1;
                        lam4=0; minl=0;
                    }
                }
                if  (ys4 + sp4 + 60 + ys44 >= yboss + y && ys4 + sp4 + 40 + ys44 <= yboss + y + 200 && xs4 + 40 + xs44 <= xboss + x + 200 && xs4 + 40 + xs44 >= xboss + x && l4==0) {
                    yboss = yboss -75;
                }
            }
            if (m == 3 && l == 0 && ammo>0) {
                l3 = 0;
                l = -1;
                if(lam3==0){ammo=ammo-1;}
            }
            if (l3 == 0) {//right
                lam3=1;
                if(stop==0){sp3 = sp3 + 10;}
                if(stop!=0){sp3 = sp3;}
                g.fillOval(xs3 + sp3 + 40 + xs33, ys3 + 20 + ys33, 20, 20);

                if (xs3 + sp3 + 70 + xs33 >= 1920){
                    sp3 = 0;
                    l = -1;
                    l3 = -1;
                    xs3 = 910;
                    ys3 = 475;
                    ys33 = 0;
                    xs33 = 0;
                    lam3=0;
                }
                if (xs3 + sp3 + 40 + xs33 <= xm + x + 100 && xs3 + sp3 + 60 + xs33 >= xm + x && ys3 + 40 + ys33 >= ym + y && ys3 + 40 + ys33 <= ym + 100 + y) {
                    sp3 = 0;
                    l = -1;
                    l3 = -1;
                    xs3 = 910;
                    ys3 = 475;
                    ys33 = 0;
                    xs33 = 0;
                    a= (int) (Math.random()*4);
                    if (a==0){xm=-100-x; ym=-100-y;}
                    if (a==1){xm=1920-x; ym=-100-y;}
                    if (a==2){xm=-100-x; ym=1050-y;}
                    if (a==3){xm=1920-x; ym=1050-y;}
                    kill=kill+1;
                    lam3=0;
                }
                if (xs3 + sp3 + 40 + xs33 <= xm3 + x + 100 && xs3 + sp3 + 60 + xs33 >= xm3 + x && ys3 + 40 + ys33 >= ym3 + y && ys3 + 40 + ys33 <= ym3 + 100 + y) {
                    sp3 = 0;
                    l = -1;
                    l3 = -1;
                    xs3 = 910;
                    ys3 = 475;
                    ys33 = 0;
                    xs33 = 0;
                    c= (int) (Math.random()*4);
                    if (c==0){xm3=-100-x; ym3=-100-y;}
                    if (c==1){xm3=1920-x; ym3=-100-y;}
                    if (c==2){xm3=-100-x; ym3=1050-y;}
                    if (c==3){xm3=1920-x; ym3=1050-y;}
                    kill=kill+1;
                    lam3=0;
                }
                if (xs3 + sp3 + 40 + xs33 <= xm2 + x + 100 && xs3 + sp3 + 60 + xs33 >= xm2 + x && ys3 + 40 + ys33 >= ym2 + y && ys3 + 40 + ys33 <= ym2 + 100 + y) {
                    sp3 = 0;
                    l = -1;
                    l3 = -1;
                    xs3 = 910;
                    ys3 = 475;
                    ys33 = 0;
                    xs33 = 0;
                    b= (int) (Math.random()*4);
                    if (b==0){xm2=-100-x; ym2=-100-y;}
                    if (b==1){xm2=1920-x; ym2=-100-y;}
                    if (b==2){xm2=-100-x; ym2=1050-y;}
                    if (b==3){xm2=1920-x; ym2=1050-y;}
                    kill=kill+1;
                    lam3=0;
                }
                if (xs3 + sp3 + 40 + xs33 <= xm4 + x + 100 && xs3 + sp3 + 60 + xs33 >= xm4 + x && ys3 + 40 + ys33 >= ym4 + y && ys3 + 40 + ys33 <= ym4 + 100 + y) {
                    sp3 = 0;
                    l = -1;
                    l3 = -1;
                    xs3 = 910;
                    ys3 = 475;
                    ys33 = 0;
                    xs33 = 0;
                    monster4=monster4+1;
                    if (monster4==2){
                        xam3=xm4;
                        yam3=ym4;
                    dd= (int) (Math.random()*4);
                    if (dd==0){xm4=-100-x; ym4=-100-y;}
                    if (dd==1){xm4=1920-x; ym4=-100-y;}
                    if (dd==2){xm4=-100-x; ym4=1050-y;}
                    if (dd==3){xm4=1920-x; ym4=1050-y;}
                        monster4=0;
                        kill=kill+1;
                        lam3=0;
                    }
                }
                if (xs3 + sp3 + 40 + xs33 <= xmin + x + 150 && xs3 + sp3 + 60 + xs33 >= xmin + x && ys3 + 40 + ys33 >= ymin + y && ys3 + 40 + ys33 <= ymin + 150 + y) {
                    sp3 = 0;
                    l = -1;
                    l3 = -1;
                    xs3 = 910;
                    ys3 = 475;
                    ys33 = 0;
                    xs33 = 0;
                    miniboss=miniboss+1;
                    if (miniboss==4){
                        xam2=xmin;
                        yam2=ymin;
                        xh1=xmin+100;
                        yh1=ymin;
                        miniboss=0;
                        kill=kill+1;
                        lam3=0; minl=0;
                    }
                }
                if (xs3 + sp3 + 40 + xs33 <= xboss + x + 200 && xs3 + sp3 + 60 + xs33 >= xboss + x && ys3 + 40 + ys33 >= yboss + y && ys3 + 40 + ys33 <= yboss + 200 + y && l3==0) {
                 xboss=xboss-75;
                }
            }
            if (m == 2 && l == 0 && ammo>0) {
                l2 = 0;
                l = -1;
                if(lam2==0){ammo=ammo-1;}
            }
            if (l2 == 0) {//left
                if(stop==0){sp2 = sp2 + 10;}
                if(stop!=0){sp2 = sp2;}
                g.fillOval(xs2 - sp2 + 40 + xs22, ys2 + 20 + ys22, 20, 20);
                lam2=1;
                if (xs2 - sp2 + 40 + xs22 <= 0) {
                    sp2 = 0;
                    l = -1;
                    l2 = -1;
                    xs2 = 910;
                    ys2 = 475;
                    ys22 = 0;
                    xs22 = 0;
                    lam2=0;
                }
                if (xs2 - sp2 + 40 + xs22 <= xm + x + 100 && xs2 - sp2 + 40 + xs22 >= xm + x && ys2 + 40 + ys22 >= ym + y && ys2 + 40 + ys22 <= ym + y + 100){
                    sp2 = 0;
                    l = -1;
                    l2 = -1;
                    xs2 = 910;
                    ys2 = 475;
                    ys22 = 0;
                    xs22 = 0;
                    a= (int) (Math.random()*4);
                    if (a==0){xm=-100-x; ym=-100-y;}
                    if (a==1){xm=1920-x; ym=-100-y;}
                    if (a==2){xm=-100-x; ym=1050-y;}
                    if (a==3){xm=1920-x; ym=1050-y;}
                    kill=kill+1;
                    lam2=0;
                }
                if (xs2 - sp2 + 40 + xs22 <= xm3 + x + 100 && xs2 - sp2 + 40 + xs22 >= xm3 + x && ys2 + 40 + ys22 >= ym3 + y && ys2 + 40 + ys22 <= ym3 + y + 100){
                    sp2 = 0;
                    l = -1;
                    l2 = -1;
                    xs2 = 910;
                    ys2 = 475;
                    ys22 = 0;
                    xs22 = 0;
                    c= (int) (Math.random()*4);
                    if (c==0){xm3=-100-x; ym3=-100-y;}
                    if (c==1){xm3=1920-x; ym3=-100-y;}
                    if (c==2){xm3=-100-x; ym3=1050-y;}
                    if (c==3){xm3=1920-x; ym3=1050-y;}
                    kill=kill+1;
                    lam2=0;
                }
                if (xs2 - sp2 + 40 + xs22 <= xm2 + x + 100 && xs2 - sp2 + 40 + xs22 >= xm2 + x && ys2 + 40 + ys22 >= ym2 + y && ys2 + 40 + ys22 <= ym2 + y + 100){
                    sp2 = 0;
                    l = -1;
                    l2 = -1;
                    xs2 = 910;
                    ys2 = 475;
                    ys22 = 0;
                    xs22 = 0;
                    b= (int) (Math.random()*4);
                    if (b==0){xm2=-100-x; ym2=-100-y;}
                    if (b==1){xm2=1920-x; ym2=-100-y;}
                    if (b==2){xm2=-100-x; ym2=1050-y;}
                    if (b==3){xm2=1920-x; ym2=1050-y;}
                    kill=kill+1;
                    lam2=0;
                }
                if (xs2 - sp2 + 40 + xs22 <= xm4 + x + 100 && xs2 - sp2 + 40 + xs22 >= xm4 + x && ys2 + 40 + ys22 >= ym4 + y && ys2 + 40 + ys22 <= ym4 + y + 100){
                    sp2 = 0;
                    l = -1;
                    l2 = -1;
                    xs2 = 910;
                    ys2 = 475;
                    ys22 = 0;
                    xs22 = 0;
                    monster4=monster4+1;
                    if (monster4==2){
                        xam3=xm4;
                        yam3=ym4;
                    dd= (int) (Math.random()*4);
                    if (dd==0){xm4=-100-x; ym4=-100-y;}
                    if (dd==1){xm4=1920-x; ym4=-100-y;}
                    if (dd==2){xm4=-100-x; ym4=1050-y;}
                    if (dd==3){xm4=1920-x; ym4=1050-y;}
                        monster4=0;
                        kill=kill+1;
                        lam2=0;
                    }
                }
                if (xs2 - sp2 + 40 + xs22 <= xmin + x + 150 && xs2 - sp2 + 40 + xs22 >= xmin + x && ys2 + 40 + ys22 >= ymin + y && ys2 + 40 + ys22 <= ymin + y + 150){
                    sp2 = 0;
                    l = -1;
                    l2 = -1;
                    xs2 = 910;
                    ys2 = 475;
                    ys22 = 0;
                    xs22 = 0;
                    miniboss=miniboss+1;
                    if (miniboss==4){
                        xam2=xmin;
                        yam2=ymin;
                        xh1=xmin+100;
                        yh1=ymin;
                        miniboss=0;
                        kill=kill+1;
                        lam2=0; minl=0;
                    }
                }
                if (xs2 - sp2 + 40 + xs22 <= xboss + x + 200 && xs2 - sp2 + 40 + xs22 >= xboss + x && ys2 + 40 + ys22 >= yboss + y && ys2 + 40 + ys22 <= yboss + y + 200 && l2==0){
                    xboss=xboss+75;
                    }
            }
            if (m == 1 && l == 0 && ammo>0) {
                l1 = 0;
                l = -1;
                if(lam==0){ammo=ammo-1;}
            }
            if (l1 == 0) {//down
                if(stop==0){sp1 = sp1 + 10;}
                if(stop!=0){sp1 = sp1;}
                g.fillOval(xs1 + xs11 + 40, ys1 - sp1 + 40 + ys11, 20, 20);
                lam=1;
                if (ys1 - sp1 + 40 + ys11 <= 0) {
                    sp1 = 0;
                    l = -1;
                    l1 = -1;
                    xs1 = 910;
                    ys1 = 475;
                    ys11 = 0;
                    xs11 = 0;
                    lam=0;
                }
                if (ys1 - sp1 + 40 + ys11 >= ym + y && ys1 - sp1 + 40 + ys11 <= ym + 100 + y && xs1 + 40 + xs11 <= xm + x + 100 && xs1 + 40 + xs11 >= xm + x) {
                    sp1 = 0;
                    l = -1;
                    l1 = -1;
                    xs1 = 910;
                    ys1 = 475;
                    ys11 = 0;
                    xs11 = 0;
                    a= (int) (Math.random()*4);
                    if (a==0){xm=-100-x; ym=-100-y;}
                    if (a==1){xm=1920-x; ym=-100-y;}
                    if (a==2){xm=-100-x; ym=1050-y;}
                    if (a==3){xm=1920-x; ym=1050-y;}
                    kill=kill+1;
                    lam=0;
                }
                if (ys1 - sp1 + 40 + ys11 >= ym3 + y && ys1 - sp1 + 40 + ys11 <= ym3 + 100 + y && xs1 + 40 + xs11 <= xm3 + x + 100 && xs1 + 40 + xs11 >= xm3 + x) {
                    sp1 = 0;
                    l = -1;
                    l1 = -1;
                    xs1 = 910;
                    ys1 = 475;
                    ys11 = 0;
                    xs11 = 0;
                    c= (int) (Math.random()*4);
                    if (c==0){xm3=-100-x; ym3=-100-y;}
                    if (c==1){xm3=1920-x; ym3=-100-y;}
                    if (c==2){xm3=-100-x; ym3=1050-y;}
                    if (c==3){xm3=1920-x; ym3=1050-y;}
                    kill=kill+1;
                    lam=0;
                }
                if (ys1 - sp1 + 40 + ys11 >= ym2 + y && ys1 - sp1 + 40 + ys11 <= ym2 + 100 + y && xs1 + 40 + xs11 <= xm2 + x + 100 && xs1 + 40 + xs11 >= xm2 + x) {
                    sp1 = 0;
                    l = -1;
                    l1 = -1;
                    xs1 = 910;
                    ys1 = 475;
                    ys11 = 0;
                    xs11 = 0;
                    b= (int) (Math.random()*4);
                    if (b==0){xm2=-100-x; ym2=-100-y;}
                    if (b==1){xm2=1920-x; ym2=-100-y;}
                    if (b==2){xm2=-100-x; ym2=1050-y;}
                    if (b==3){xm2=1920-x; ym2=1050-y;}
                    kill=kill+1;
                    lam=0;
                }
                if (ys1 - sp1 + 40 + ys11 >= ym4 + y && ys1 - sp1 + 40 + ys11 <= ym4 + 100 + y && xs1 + 40 + xs11 <= xm4 + x + 100 && xs1 + 40 + xs11 >= xm4 + x) {
                    sp1 = 0;
                    l = -1;
                    l1 = -1;
                    xs1 = 910;
                    ys1 = 475;
                    ys11 = 0;
                    xs11 = 0;
                    monster4=monster4+1;
                    if (monster4==2){
                        xam3=xm4;
                        yam3=ym4;
                    dd= (int) (Math.random()*4);
                    if (dd==0){xm4=-100-x; ym4=-100-y;}
                    if (dd==1){xm4=1920-x; ym4=-100-y;}
                    if (dd==2){xm4=-100-x; ym4=1050-y;}
                    if (dd==3){xm4=1920-x; ym4=1050-y;}
                        monster4=0;
                        kill=kill+1;
                        lam=0;
                    }
                }
                if (ys1 - sp1 + 40 + ys11 >= ymin + y && ys1 - sp1 + 40 + ys11 <= ymin + 150 + y && xs1 + 40 + xs11 <= xmin + x + 150 && xs1 + 40 + xs11 >= xmin + x) {
                    sp1 = 0;
                    l = -1;
                    l1 = -1;
                    xs1 = 910;
                    ys1 = 475;
                    ys11 = 0;
                    xs11 = 0;
                    miniboss=miniboss+1;
                    if (miniboss==4){
                        xam2=xmin;
                        yam2=ymin;
                        xh1=xmin+100;
                        yh1=ymin;
                        miniboss=0;
                        kill=kill+1;
                        lam=0; minl=0;
                    }
                }
                if (ys1 - sp1 + 40 + ys11 >= yboss + y && ys1 - sp1 + 40 + ys11 <= yboss + 200 + y && xs1 + 40 + xs11 <= xboss + x + 200 && xs1 + 40 + xs11 >= xboss + x && l1==0) {
                       yboss=yboss+75;
                    }

            }

        if(stop==0){hero=hero+1;}
        if(stop!=0){hero=hero;}
        if (hero<=10){g.drawImage(op.filter(doom, null), x1, y1, 100, 100, null);}
        if (hero>10){g.drawImage(op.filter(doom2, null), x1, y1, 100, 100, null);}
        if (hero==20){hero=0;}

        if(stop==0){plump1=plump1+1;}
        if(stop!=0){plump1=plump1;}
        if (stop==0 && plump1<=10 && bossl==0){plumpy1=plumpy1+1;g.drawImage(mon1, xm + x, ym + y, 100+plumpy1, 100+plumpy1, null);}
        if (stop!=0 && plump1<=10 && bossl==0){plumpy1=plumpy1;g.drawImage(mon1, xm + x, ym + y, 100+plumpy1, 100+plumpy1, null);}
        if (stop==0 && plump1>10 && bossl==0){plumpy1=plumpy1-1;g.drawImage(mon12, xm + x, ym + y, 100+plumpy1, 100+plumpy1, null);}
        if (stop!=0 && plump1>10 && bossl==0){plumpy1=plumpy1;g.drawImage(mon12, xm + x, ym + y, 100+plumpy1, 100+plumpy1, null);}
        if (plump1==20){plump1=0;}
        if (bossl==1){g.drawImage(shadow, xm + x, ym + y, 100, 100, null);}

        if(stop==0){plump2=plump2+1;}
        if(stop!=0){plump2=plump2;}
        if (stop==0 && plump2<=20 && plump2>=10 && bossl==0){plumpy2=plumpy2+1;g.drawImage(mon1, xm3 + x, ym3 + y, 100+plumpy2, 100+plumpy2, null);}
        if (stop==0 && plump2>20 && bossl==0){plumpy2=plumpy2-1;g.drawImage(mon12, xm3 + x, ym3 + y, 100+plumpy2, 100+plumpy2, null);}
        if (stop!=0 && plump2<=20 && plump2>=10 && bossl==0){plumpy2=plumpy2;g.drawImage(mon1, xm3 + x, ym3 + y, 100+plumpy2, 100+plumpy2, null);}
        if (stop!=0 && plump2>20 && bossl==0){plumpy2=plumpy2;g.drawImage(mon12, xm3 + x, ym3 + y, 100+plumpy2, 100+plumpy2, null);}
        if (plump2==30){plump2=10;}
            if (bossl==1){g.drawImage(shadow, xm3 + x, ym3 + y, 100, 100, null);}

        if(stop==0){plump3=plump3+1;}
        if(stop!=0){plump3=plump3;}
        if (stop==0 && plump3<=15 && plump3>=8){plumpy3=plumpy3+1;g.drawImage(mon2, xm2 + x, ym2 + y, 100+plumpy3, 100+plumpy3, null);}
        if (stop==0 && plump3>15){plumpy3=plumpy3-1;g.drawImage(mon22, xm2 + x, ym2 + y, 100+plumpy3, 100+plumpy3, null);}
        if (stop!=0 && plump3<=15 && plump3>=8){plumpy3=plumpy3;g.drawImage(mon2, xm2 + x, ym2 + y, 100+plumpy3, 100+plumpy3, null);}
        if (stop!=0 && plump3>15){plumpy3=plumpy3;g.drawImage(mon22, xm2 + x, ym2 + y, 100+plumpy3, 100+plumpy3, null);}
        if (plump3==22){plump3=8;}

        if(stop==0){plump4=plump4+1;}
        if(stop!=0){plump4=plump4;}
        if (stop==0 && plump4<=25 && plump4>=15){plumpy4=plumpy4+1;g.drawImage(mon3, xm4 + x, ym4 + y, 100+plumpy4, 100+plumpy4, null);}
        if (stop==0 && plump4>25){plumpy4=plumpy4-1;g.drawImage(mon32, xm4 + x, ym4 + y, 100+plumpy4, 100+plumpy4, null);}
        if (stop!=0 && plump4<=25 && plump4>=15){plumpy4=plumpy4;g.drawImage(mon3, xm4 + x, ym4 + y, 100+plumpy4, 100+plumpy4, null);}
        if (stop!=0 && plump4>25){plumpy4=plumpy4;g.drawImage(mon32, xm4 + x, ym4 + y, 100+plumpy4, 100+plumpy4, null);}
        if (plump4==35){plump4=15;}

        if(stop==0){facemin=facemin+1;}
        if(stop!=0){facemin=facemin;}
        if (stop==0 && facemin<=10){g.drawImage(mon4, xmin + x, ymin + y, 150+plumpymin, 150+plumpymin, null);}
        if (stop==0 && facemin>10){g.drawImage(mon42, xmin + x, ymin + y, 150+plumpymin, 150+plumpymin, null);}
        if (stop!=0 && facemin<=10){g.drawImage(mon4, xmin + x, ymin + y, 150+plumpymin, 150+plumpymin, null);}
        if (stop!=0 && facemin>10){g.drawImage(mon42, xmin + x, ymin + y, 150+plumpymin, 150+plumpymin, null);}
        if (facemin==20){facemin=0;}
        g.drawImage(boss, xboss+x, yboss+y, 200, 200, null);

            g.drawImage(el4, swx4, swy4, 25, 100, null);
            g.drawImage(el3, swx3, swy3, 100, 25, null);
            g.drawImage(el2, swx2, swy2, 100, 25, null);
            g.drawImage(el1, swx1, swy1, 25, 100, null);

        g.drawImage(shield, xsh, 450, 110, 110, null);
            g.drawImage(back, 0, 0, null);

            Font f1 = new Font("TimesRoman", Font.BOLD, 40),
                    f4 = new Font("TimesRoman", Font.BOLD, 100),
                    f2 = new Font("TimesRoman", Font.BOLD, 40);
            String str = "Kills "+kill;
            String str2 =""+ammo;
            String str3 =""+spsw;
            String str4 ="You killed "+kill+" monsters";

        {Graphics2D g2 = (Graphics2D) g;//.setBackground(Color.gray); Dimension d = getSize(null);g2.clearRect(0, 0, d.width, d.height);//NO DELETE
            g2.setColor(Color.cyan);
            // выводим строку тремя разными шрифтами
            g2.setFont(f1);
            g2.setColor(Color.red);
            g2.drawString(str, 1690, 968);
            g2.setColor(Color.black);
            g2.setFont(f2);
            g2.drawString(str2, 1800, 180);
            g2.setColor(Color.blue);
            g2.drawString(str3, 1830, 253);
        }
            g.drawImage(hp, hpx1, hpy1, 50, 50, null);
            g.drawImage(hp, hpx2, hpy2, 50, 50, null);
            g.drawImage(ar, arx1, ary1, 50, 50, null);
            g.drawImage(ar, arx2, ary2, 50, 50, null);
            g.drawImage(am, 1740, 140, 50, 50, null);
   if(stop!=0){g.drawImage(pause, 0, 0, 1920, 1050, null);}

            g.setColor(Color.black);
            if(hpx2==1950){g.fillRect(0, 0, 1920, 1050);}
        {Graphics2D g2 = (Graphics2D) g;//.setBackground(Color.gray); Dimension d = getSize(null);g2.clearRect(0, 0, d.width, d.height);//NO DELETE
            g2.setColor(Color.red);
            g2.setFont(f4);
            if(hpx2==1950){g2.drawString(str4, 300, 500);}
        }
         if(stop==0){
         x=x+chx; y=y+chy;}
         if(stop!=0){x=x;y=y;}
        if(l1==0 && stop==0){xs11=xs11+chx1; ys11=ys11+chy4;}
        if(l2==0 && stop==0){xs22=xs22+chx2; ys22=ys22+chy3;}
        if(l3==0 && stop==0){xs33=xs33+chx3; ys33=ys33+chy2;}
        if(l4==0 && stop==0){xs44=xs44+chx4; ys44=ys44+chy1;}

        if(l1==0 && stop!=0){xs11=xs11; ys11=ys11;}
        if(l2==0 && stop!=0){xs22=xs22; ys22=ys22;}
        if(l3==0 && stop!=0){xs33=xs33; ys33=ys33;}
        if(l4==0 && stop!=0){xs44=xs44; ys44=ys44;}

        if(l1==-1){xs11=0; ys11=0;}
        if(l2==-1){xs22=0; ys22=0;}
        if(l3==-1){xs33=0; ys33=0;}
        if(l4==-1){xs44=0; ys44=0;}


    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
    int pol =0;
    int c = e.getKeyCode();
        int z = e.getID();
        if(c== KeyEvent.VK_B && z==401) {
            kill=kill+1;
        }
        if(c== KeyEvent.VK_Z && z==401) {
            ammo=ammo+3;
        }
        if(c== KeyEvent.VK_X && z==401) {
            ammo=ammo-3;
        }
        if(c== KeyEvent.VK_P && z==401) {
            if(stop==0 && pol==0){stop=1; pol=1;}
            if(stop==1 && pol==0){stop=0; pol=1;}
        }
        if(c== KeyEvent.VK_P && z==402) { pol=0;}
        if(c== KeyEvent.VK_SPACE && z==401 && ammo!=0 && stop==0) {
            l=0;
            repaint();}
        if (z==402){chx=0;chy=0;chx1=0;chy1=0;chx2=0;chy2=0;chx3=0;chy3=0;chx4=0;chy4=0;sl=-1;}
        if(c== KeyEvent.VK_ENTER && z==401 ) {sl=0;}
        if(c== KeyEvent.VK_ENTER && z==402 ) {if(stop==0){spsw=0;}}
        if(c== KeyEvent.VK_W && z==401) {
             chx=0;
             chy=8;
            chx1=0;
            chy1=8;
            chx2=0;
            chy2=8;
            chx3=0;
            chy3=8;
            chx4=0;
            chy4=8;
            if(stop==0){d=180.0;}
            if(stop==0){m=1;}
            if(stop==0){sw=1;}

            repaint();
        }

        if(c== KeyEvent.VK_A && z==401){
            chx=10;
            chy=0;
            chx1=10;
            chy1=0;
            chx2=10;
            chy2=0;
            chx3=10;
            chy3=0;
            chx4=10;
            chy4=0;
            if(stop==0){d=90.0;}
            if(stop==0){m=2;}
            if(stop==0){sw=2;}
            repaint();
        }

        if(c==KeyEvent.VK_D && z==401) {
            chx =- 10;
            chy = 0;
            chx1 =- 10;
            chy1 = 0;
            chx2 =- 10;
            chy2 = 0;
            chx3 =- 10;
            chy3 = 0;
            chx4 =- 10;
            chy4 = 0;
            if(stop==0){d=270.0;}
            if(stop==0){m=3;}
            if(stop==0){sw=3;}
            repaint();
        }

        if(c== KeyEvent.VK_S && z==401) {
            chx = 0;
            chy =- 8;
            chx1 = 0;
            chy1 =- 8;
            chx2 = 0;
            chy2 =- 8;
            chx3 = 0;
            chy3 =- 8;
            chx4 = 0;
            chy4 =- 8;
            if(stop==0){d=0.0;}
            if(stop==0){m=4;}
            if(stop==0){sw=4;}

            repaint();
        }
        return false;
    }

}