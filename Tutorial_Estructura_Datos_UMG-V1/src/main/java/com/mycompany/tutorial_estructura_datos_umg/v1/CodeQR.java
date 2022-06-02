/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tutorial_estructura_datos_umg.v1;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import javax.imageio.ImageIO;
/**
 *
 * @author Arrecis
 */
public class CodeQR {
    
    
   public void GenerarQR(String [] datos) {
        try {
            String content = datos[0]+" "+datos[1];
            String filePath ="QR/";
            String fileType = "png";
            int size = 225;
            UUID uuid = UUID.randomUUID();
            String randomUUIDString = uuid.toString();
            QRCodeWriter qrcode = new QRCodeWriter();
            BitMatrix matrix = qrcode.encode(content, BarcodeFormat.QR_CODE, size, size);
            File qrFile = new File(filePath + "Codigo" + "." + fileType);
            int matrixWidth = matrix.getWidth();
            BufferedImage image = new BufferedImage(matrixWidth, matrixWidth, BufferedImage.TYPE_INT_RGB);
            image.createGraphics();
            
            Graphics2D graphics = (Graphics2D) image.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, matrixWidth, matrixWidth);
            graphics.setColor(Color.BLACK);
            
            for (int b = 0; b < matrixWidth; b++) {
                for (int j = 0; j < matrixWidth; j++) {
                    if (matrix.get(b, j)) {
                        graphics.fillRect(b, j, 1, 1);
                    }
                }
            }
            ImageIO.write(image, fileType, qrFile);
            System.out.println("creado con exito!!");
        } catch (Exception ex) {
            //Logger.getLogger(FormularioDeEntrega.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
