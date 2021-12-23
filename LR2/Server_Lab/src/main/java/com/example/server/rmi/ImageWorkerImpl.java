package com.example.server.rmi;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ImageWorkerImpl extends UnicastRemoteObject implements ImageWorker {
    public ImageWorkerImpl() throws RemoteException {
        super();
    }

    @Override
    public byte[] filter(byte[] byteOfImage) throws RemoteException {
        BufferedImage inputImage = getBufferedImage(byteOfImage);
        BufferedImage resultImage = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), inputImage.getType());
        new ConvolveOp(new Kernel(3, 3, new float[]{0, -1, 0, -1, 5, -1, 0, -1, 0})).filter(inputImage, resultImage);
        resultImage.setData(resultImage.getRaster());
        return getByteArrayOfImage(resultImage);
    }

    public byte[] getByteArrayOfImage(BufferedImage image) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public BufferedImage getBufferedImage(byte[] byteOfImage) {
        try {
            return ImageIO.read(new ByteArrayInputStream(byteOfImage));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
