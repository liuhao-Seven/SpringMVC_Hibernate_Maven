package test;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
/**
 * 通过pdfbox转pdf至jpg  测试
 * @description:
 * @author 刘浩
 * @date 2015-7-1 下午3:21:45 
 * @version V1.0  
 *
 */
public class PdfToJpgTest2 {
	@SuppressWarnings({"rawtypes" })
	public static void main(String[] args) {
		try {
			PDDocument doc = PDDocument.load("E:/test/lcpoldata_20150601_08_21_47_86110020150210045039.pdf");
			List pages = doc.getDocumentCatalog().getAllPages();
			for (int i = 0; i < pages.size(); i++) {
				PDPage page = (PDPage) pages.get(i);
				BufferedImage image = page.convertToImage();
				Iterator iter = ImageIO.getImageWritersBySuffix("jpg");
				ImageWriter writer = (ImageWriter) iter.next();
				File outFile = new File("E:/test/picture/" +i+ ".jpg");
				FileOutputStream out = new FileOutputStream(outFile);
				ImageIO.write(image, "jpg", out);
//				ImageOutputStream outImage = ImageIO.createImageOutputStream(out);
//				writer.setOutput(outImage);
//				writer.write(new IIOImage(image, null, null));
			}
			doc.close();
			System.out.println("over");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
