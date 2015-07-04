package test;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
 
import org.icepdf.core.pobjects.Document;
import org.icepdf.core.pobjects.Page;
import org.icepdf.core.util.GraphicsRenderingHints;

/**
 * icepdf-viewer 转pdf to jpg
 * 
 * @description:
 * @author 刘浩
 * @date 2015-7-4 下午8:21:04
 * @version V1.0
 * 
 */
public class PdfToJpgTest3 {
	public static void main(String[] args) {
//		String filePath = "E:/test/lcpoldata_20150601_08_21_47_86110020150210045039.pdf";
		String filePath = "E:/test/Maven实战.pdf";
		
		Document document = new Document();
		try {
			document.setFile(filePath);
		} catch (Exception ex) {
		}

		// save page caputres to file.
		float scale = 2f;
		float rotation = 0f;

		// Paint each pages content to an image and write the image to file
		for (int i = 0; i < document.getNumberOfPages(); i++) {
			BufferedImage image = (BufferedImage) document.getPageImage(i,
					GraphicsRenderingHints.SCREEN, Page.BOUNDARY_CROPBOX,
					rotation, scale);
			RenderedImage rendImage = image;
			// capture the page image to file
			try {
				System.out.println("/t capturing page " + i);
				File file = new File("E:/test/picture/imageCapture1_" + i + ".png");
				ImageIO.write(rendImage, "png", file);

			} catch (IOException e) {
				e.printStackTrace();
			}
			image.flush();
		}
		// clean up resources
		document.dispose();
	}
}
