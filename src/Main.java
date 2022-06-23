import org.bytedeco.javacpp.opencv_aruco;
import org.opencv.aruco.Aruco;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.aruco.Dictionary;
import java.util.List;
import nu.pattern.OpenCV;
import org.opencv.imgcodecs.Imgcodecs;


public class Main {
    public static void main(String[] args) {

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Imgcodecs imageCodecs = new Imgcodecs();
        Mat image = imageCodecs.imread("C:\\Users\\norsy\\IdeaProjects\\openCV\\src\\target2.png");
        System.out.println("Image Loaded");

        // Dictionary dictionary = Dictionary.create(6,6);
        Dictionary dictionary = Dictionary.get(Aruco.DICT_6X6_50);
        System.out.println("Created Dictionary");
        List<Mat> corners = (List<Mat>) dictionary;
        Mat ids = new Mat();

        System.out.println(corners.toString());

        // Aruco.detectMarkers(Mat image, Dictionary dictionary, List<Mat> corners, Mat ids)
        Aruco.detectMarkers(image, dictionary, corners, ids);
        Aruco.drawDetectedMarkers(image, corners);

        Imgcodecs.imwrite("C:\\Users\\norsy\\IdeaProjects\\openCV\\src\\target2.png", image);

    }
}
