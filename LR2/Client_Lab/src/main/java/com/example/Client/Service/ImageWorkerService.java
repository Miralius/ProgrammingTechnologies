package com.example.Client.Service;

import com.example.Client.dto.Form;
import com.example.Client.rmi.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

@Service
@RequiredArgsConstructor
public class ImageWorkerService {

    private static ImageWorker imageWorker;

    public static void setImageWorker(ImageWorker imageWorker) {
        ImageWorkerService.imageWorker = imageWorker;
    }

    public static File[] filter(Form form) {
        String url = "rmi://localhost/";
        try {
            System.out.println("Клиент запущен");
            File input = new File(form.getFile1() + ".jpg");
            BufferedImage inputImg = ImageIO.read(input);
            File output1 = new File(form.getFile2() + ".jpg");
            File output2 = new File("src\\main\\resources\\static\\out\\image1.jpg");
            File output3 = new File("src\\main\\resources\\static\\out\\image2.jpg");
            ByteArrayOfImage arrayOfImage = new ByteArrayOfImage(inputImg);
            arrayOfImage = new ByteArrayOfImage(imageWorker.filter(arrayOfImage.getByteOfImage()));
            BufferedImage outputImg = arrayOfImage.getBufferedImage();
            ImageIO.write(outputImg, "jpg", output1);
            ImageIO.write(inputImg, "jpg", output2);
            ImageIO.write(outputImg, "jpg", output3);
            return new File[]{input, output1};
        } catch (Exception e) {
            System.out.println("Введен неверный путь к файлу");
        }
        return new File[2];
    }
}