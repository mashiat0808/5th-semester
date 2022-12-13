

import java.io.File;
import java.io.FileWriter;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
public class getPixels {
public static void main(String args[])throws Exception {
File file1= new File("/home/farin/5th-semester/dbms2/ibtd/Mask/0000.bmp");
File file2= new File("/home/farin/5th-semester/dbms2/ibtd/0000.jpg");
BufferedImage img1 = ImageIO.read(file1);
BufferedImage img2 = ImageIO.read(file2);

FileWriter writer = new FileWriter("pixel_values.txt");

int [][][] nonskin= new int[256][256][256];
int [][][] skin= new int[256][256][256];
int skinsum=0;
int nonskinsum= 0;
double [][][] prob1=new double[256][256][256];
double [][][] prob2=new double[256][256][256];

for(int i=0;i< 256;i++)
for(int j=0;j<256;j++)
for(int k=0;k<256;k++)
{
    nonskin[i][j][k]=0;
    skin[i][j][k]=0;
   // nonskinsum[i][j][k]=0;
   // skinsum[i][j][k]=0;
   prob1[i][j][k]=0;
   prob2[i][j][k]=0;

}

for (int y = 0; y < img1.getHeight(); y++) {
for (int x = 0; x < img1.getWidth(); x++) {
//Retrieving contents of a pixel
int pixel1 = img1.getRGB(x,y);
Color color1 = new Color(pixel1, true);
int red1 = color1.getRed();
int green1 = color1.getGreen();
int blue1 = color1.getBlue();

int pixel2 = img2.getRGB(x,y);
Color color2 = new Color(pixel2, true);
int red2 = color2.getRed();
int green2 = color2.getGreen();
int blue2 = color2.getBlue();



if(red1>240 && green1>240 && blue1>240)
{
    nonskin[red2][green2][blue2]++;
}
else skin[red2][green2][blue2]++;

}
}
for(int i=0;i<256;i++) {
    for(int j=0;j<256;j++) {
        for(int k=0;k<256;k++) {

            skinsum= skinsum+skin[i][j][k];
            nonskinsum= nonskinsum + nonskin[i][j][k];
          }
    }
}
System.out.println("skin " + skinsum+ " nonskin " +nonskinsum);

for(int i=0;i<256;i++) {
    for(int j=0;j<256;j++) {
        for(int k=0;k<256;k++) {
            prob1[i][j][k]= (double)skin[i][j][k]/skinsum;
            prob2[i][j][k]= (double)nonskin[i][j][k]/nonskinsum;
            if(prob2[i][j][k]==0) {
               writer.append(" 0 ");

            }
            else
            
            writer.append((char)(double)(prob1[i][j][k]/prob2[i][j][k]));
            writer.flush();
         
          }
    }
}

writer.close();

}

}