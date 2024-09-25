import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class mouseteclado {

	public void opencmd() throws AWTException {
		Robot r = new Robot();
		String text = "cmd";
		StringSelection stringSelection = new StringSelection(text);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, stringSelection);
		r.setAutoDelay(50);
		r.keyPress(KeyEvent.VK_WINDOWS);
		r.keyPress(KeyEvent.VK_R);
		r.keyRelease(KeyEvent.VK_WINDOWS);
		r.keyRelease(KeyEvent.VK_R);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public void pastenter(String text) throws AWTException {
		Robot r = new Robot();
		StringSelection stringSelection = new StringSelection(text);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, stringSelection);
		r.setAutoDelay(50);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public void desligar() throws IOException {
		Runtime.getRuntime().exec("shutdown /s /t 10");
	}

	// funçao para testar outras funções antes de implementar
	public void movimentoteste() throws AWTException, IOException {
		opencmd();
		// pastenter("cd C:\\Users\\Shuri\\Desktop\\projeto\\ShuriApp");
		// pastenter("compilador");
		// pastenter("s");
		// pastenter("executeShuriApp");
		// pastenter("exit");

	}

	public void movimento0() throws AWTException, IOException {
		opencmd();
		pastenter("cd desktop");
		pastenter("cd projeto");
		pastenter("cd ShuriApp");
		pastenter("start main.java");
	}

	public void Movimento1() throws AWTException {
		opencmd();
		pastenter("cd desktop");
		pastenter("cd projeto");
		pastenter("cd projetos");
		pastenter("start 1.bat");
	}

	public void Movimento2() throws AWTException {

		Robot r = new Robot();
		int b = InputEvent.BUTTON1_DOWN_MASK;

		// String text = "google.com";
		// StringSelection stringSelection = new StringSelection(text);
		// Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		// clipboard.setContents(stringSelection, stringSelection);

		// r.mouseMove(700,1055);
		// r.delay(10);
		// r.mousePress(b);
		// r.delay(10);
		// r.mouseRelease(b);
		// r.delay(10);
		// r.mouseMove(700,50);
		// r.delay(10);
		// r.keyPress(KeyEvent.VK_WINDOWS);
		// r.keyPress(KeyEvent.VK_UP);
		// r.delay(10);
		// r.keyRelease(KeyEvent.VK_WINDOWS);
		// r.keyRelease(KeyEvent.VK_UP);
		// r.delay(10);
		// r.mouseMove(0,15);

		// r.delay(3000);

		// r.mouseMove(650,355);

		// r.delay(100);

		// Color h = r.getPixelColor(652,455);

		r.keyPress(KeyEvent.VK_WINDOWS);
		r.keyPress(KeyEvent.VK_D);
		r.keyRelease(KeyEvent.VK_WINDOWS);
		r.keyRelease(KeyEvent.VK_D);
		r.delay(100);
		r.keyPress(KeyEvent.VK_WINDOWS);
		r.keyPress(KeyEvent.VK_R);
		r.keyRelease(KeyEvent.VK_WINDOWS);
		r.keyRelease(KeyEvent.VK_R);
		r.delay(100);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.delay(100);

		// String x;

		// x = h.toString();

		// if(x == "java.awt.Color[r=0,g=175,b=156]")
		{
			// System.out.println("msg");
		}
		// else
		// {
		System.out.println("funfa");
		// }

		// System.out.println(x);

	}

	public void Movimento3() throws AWTException {

		Robot r = new Robot();
		int b = InputEvent.BUTTON1_DOWN_MASK;

		// r.keyPress(KeyEvent.);
	}

	public void Movimento4() throws AWTException {
		opencmd();
		pastenter("cd desktop");
		pastenter("bait.mp3");
	}

	public void Movimento5() throws AWTException {
		opencmd();
		pastenter("cd desktop");
		pastenter("qualfoi1.png");
	}

	public void Movimento6() throws AWTException {
		opencmd();
		pastenter("cd desktop");
		pastenter("funciona.png");
	}

	public void Movimento21() throws AWTException {
		Robot r = new Robot();
		int b = InputEvent.BUTTON1_DOWN_MASK;

		String text = "google.com";
		StringSelection stringSelection = new StringSelection(text);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, stringSelection);

		r.mouseMove(700, 1055);
		r.delay(10);
		r.mousePress(b);
		r.delay(10);
		r.mouseRelease(b);
		r.delay(10);
		r.mouseMove(700, 50);
		r.delay(10);
		r.keyPress(KeyEvent.VK_WINDOWS);
		r.keyPress(KeyEvent.VK_UP);
		r.delay(10);
		r.keyRelease(KeyEvent.VK_WINDOWS);
		r.keyRelease(KeyEvent.VK_UP);
		r.delay(10);
		r.mouseMove(1450, 15);
		r.delay(10);
		r.mousePress(b);
		r.delay(10);
		r.mouseRelease(b);
		r.delay(10);
		r.mouseMove(700, 50);
		r.delay(10);
		r.mousePress(b);
		r.delay(10);
		r.mouseRelease(b);
		r.delay(10);
		r.mousePress(b);
		r.delay(10);
		r.mouseRelease(b);
		r.delay(10);
		r.mousePress(b);
		r.delay(10);
		r.mouseRelease(b);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.delay(10);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.delay(10);
		r.keyPress(KeyEvent.VK_ENTER);
		r.delay(10);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.delay(10);
		r.mouseMove(750, 475);
		r.delay(10);
		text = "jorge fernando da cruz";
		stringSelection = new StringSelection(text);
		clipboard.setContents(stringSelection, stringSelection);
		r.delay(1000);
		r.mousePress(b);
		r.delay(10);
		r.mouseRelease(b);
		r.delay(10);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.delay(10);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.delay(10);
		r.keyPress(KeyEvent.VK_ENTER);
		r.delay(10);
		r.keyRelease(KeyEvent.VK_ENTER);

		r.delay(3000);

		r.mouseMove(650, 355);

		r.delay(100);

		Color h = r.getPixelColor(652, 455);

		System.out.println(h);

		/*
		 * BufferedImage bi= r.createScreenCapture(new Rectangle(100,100));
		 * try {
		 * ImageIO.write(bi, "jpg", new File("C:/Riot Games/imageTest.jpg"));
		 * } catch (IOException e) {
		 * // TODO Auto-generated catch block
		 * e.printStackTrace();
		 * }
		 */

	}

}
