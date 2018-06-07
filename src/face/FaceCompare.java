package face;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.openimaj.feature.FloatFVComparison;
import org.openimaj.image.ImageUtilities;
import org.openimaj.image.processing.face.detection.DetectedFace;
import org.openimaj.image.processing.face.detection.HaarCascadeDetector;
import org.openimaj.image.processing.face.feature.FaceImageFeature;
import org.openimaj.image.processing.face.feature.FaceImageFeature.Extractor;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;

public class FaceCompare {
	private static final HaarCascadeDetector detector = new HaarCascadeDetector();
	private Webcam webcam = null;
	
	private Extractor<DetectedFace> faceExtractor = new Extractor<DetectedFace>();
	public static void main(String[] args){
		new FaceCompare();
	}
	
	
	public double getCorrelationOfFeatures(){
		BufferedImage img = null;
		try {
			img = ImageIO.read(getClass().getResource("/face.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		FaceImageFeature screenCapFace = getFeature(getScreenCapture());
		FaceImageFeature originalFace = getFeature(img);
		
		return screenCapFace.getFeatureVector().compare(originalFace.getFeatureVector(), FloatFVComparison.CORRELATION);
	}

	// Take a screen cap from the webcam
	public BufferedImage getScreenCapture() {
		BufferedImage img;
		webcam = Webcam.getDefault();
		webcam.setViewSize(WebcamResolution.VGA.getSize());
		webcam.open();
		img = webcam.getImage();
		webcam.close();
		return img;
	}

	public FaceImageFeature getFeature(BufferedImage img) {
		// Detect any faces in the image and store them inside the faces list
		List<DetectedFace> faces = detector.detectFaces(ImageUtilities.createFImage(img));
		// Make sure we found a face
		if (faces.size() < 1) {
			System.out.println("No faces found in the captured image");
			return null;
		}
		// Extract the face features of the ground face
		return faceExtractor.extractFeature(faces.get(0));
	}
}
