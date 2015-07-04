package test;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;

/**
 * 通过pdfRenderer转pdf至jpg  测试    --缺陷:中文无法转换
 * @description:
 * @author 刘浩
 * @date 2015-7-1 下午3:22:34 
 * @version V1.0  
 *
 */
@SuppressWarnings("restriction")
public class PdfToJpgTest {
	public static void changePdfToJpg() throws IOException {

		// load a pdf from a byte buffer
		File file = new File(
				"E:/test/lcpoldata_20150601_08_21_47_86110020150210045039.pdf");
		RandomAccessFile raf = new RandomAccessFile(file, "r");
		FileChannel channel = raf.getChannel();
		ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel
				.size());
		PDFFile pdffile = new PDFFile(buf);

		System.out.println("页数： " + pdffile.getNumPages());

		for (int i = 1; i <= pdffile.getNumPages(); i++) {
			// draw the first page to an image
			PDFPage page = pdffile.getPage(i);

			// get the width and height for the doc at the default zoom
			Rectangle rect = new Rectangle(0, 0, (int) page.getBBox()
					.getWidth(), (int) page.getBBox().getHeight());

			int n = 6;/**图片清晰度（n>0且n<7）【pdf放大参数】*/
			
			// generate the image
			Image img = page.getImage(rect.width*n, rect.height*n, // width &
																// height
					rect, // clip rect
					null, // null for the ImageObserver
					true, // fill background with white
					true // block until drawing is done
					);

			BufferedImage tag = new BufferedImage(rect.width*n, rect.height*n,
					BufferedImage.TYPE_INT_RGB);
			tag.getGraphics().drawImage(img, 0, 0, rect.width*n, rect.height*n,
					null);
			FileOutputStream out = new FileOutputStream(
					"E:/test/picture//"+file.getName()+"_"
							+ i + ".jpg"); // 输出到文件流
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			encoder.encode(tag); // JPEG编码

			out.close();
		}

		// show the image in a frame
		// JFrame frame = new JFrame("PDF Test");
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.add(new JLabel(new ImageIcon(img)));
		// frame.pack();
		// frame.setVisible(true);
	}

	public static void main(String[] args) {
		try {
			System.out.println("ssss");
			PdfToJpgTest.changePdfToJpg();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
