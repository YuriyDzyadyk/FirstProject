
package lv.lgs.serviceImplementation;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUpdatingService  {

	//������������ ��������!! 
    public String writeFile(String carId, MultipartFile file) {
        File relativePath = new File("/sitemap/upload"); //����� � ���� ���� ����������� ���� 
        File f = new File(System.getProperty("catalina.home")+relativePath); /* catalina.home-- Tomcat (����� �� ������ F:-Tomcat-sitemap-upload)??������ �������� � F:-Workspace-sitemap-upload)*/
        
        if(!f.exists()){
            f.mkdirs();
        }
        try {//??
        	//���������� ����� ������������� ����� �������
        	//���� ��������
            BufferedImage bi = ImageIO.read(new ByteArrayInputStream(file.getBytes()));  
            //���� �� ������� ����� �������  
          //���������� �������� � ��������� �� ���� ��������
            if(file.getOriginalFilename().endsWith(".jpeg")){
               relativePath = new File(relativePath+File.separator+carId+".jpeg");
                File path = new File(f+File.separator+carId+".jpeg");
                ImageIO.write(bi, "jpeg", path);
                return String.valueOf(relativePath);
            } else if (file.getOriginalFilename().endsWith(".jpg")){
                relativePath = new File(relativePath+File.separator+carId+".jpg");
                File path = new File(f+File.separator+carId+".jpg");
                ImageIO.write(bi, "png", path);
                return String.valueOf(relativePath);
            } else if(file.getOriginalFilename().endsWith(".png")){
                relativePath = new File(relativePath+File.separator+carId+".png");
                File path = new File(f+File.separator+carId+".png");
                ImageIO.write(bi, "png", path);
                return String.valueOf(relativePath);
            }
        } catch (IOException e) {//??
            e.printStackTrace();//??
        }
        return null;
    }
	
    
}
