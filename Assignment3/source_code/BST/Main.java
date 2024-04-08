
import java.util.*;


// Remove Imports if xchart not working
import org.knowm.xchart.*;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;
import org.knowm.xchart.style.markers.SeriesMarkers;



public class Main{

// Function to generate a random number
public static int generateRandomNumber(int n){
    Random random = new Random();

    int r = random.nextInt(n+1);

    return r;

}

// Function to generate a random even number
public static int generateRandomEvenNumber(int n){
    Random random = new Random();

    int r = random.nextInt(n+1);

    r = ((r/2) + 1 )*2;

    return r;
}


public static void main(String[] args) throws Exception{

    // Initialize the binary search tree and height and time array lists
    BinarySearchTree<Integer> bst = new BinarySearchTree<>();
    ArrayList<Integer> hi = new ArrayList<Integer>();
    ArrayList<Double> ti = new ArrayList<>();
    Random random = new Random();

    int m = random.nextInt(200 - 100 +1) + 100;

    // Put 100 random integers between 0 and 300 into the binary search tree
    for (int i = 100; i <= m; i++){
        int ri = generateRandomNumber(300);
            if (!bst.contains(ri)){

                bst.add(ri);
            }

    }


    // Print the binary search tree
    System.out.println("Inorder traversal of the BST:");
    bst.inorderTraversal();
    System.out.println();

    // Print the even binary search tree
    bst.removeOddValues();
    System.out.println("Inorder traversal of the Even BST:");
    bst.inorderTraversal();
    System.out.println();


    // Get k between 50 and 150
    int k = random.nextInt(150 - 50 +1) + 50;

    
    for(int i = 50; i <= k; i++){


    int r = generateRandomNumber(300);

    
    if (!bst.contains(r)){


        int height = bst.findHeight(bst.getRoot());

        hi.add(height);


        long startTime = System.nanoTime();
        bst.add(r);
        long endTime = System.nanoTime();


        double time = endTime - startTime;

        ti.add(time);
        

    }
    

    }



    // Create Chart
    XYChart chart =
    new XYChartBuilder()
        .width(800)
        .height(600)
        .title("Height vs Time of a Binary Search Tree")
        .xAxisTitle("Time (ns)")
        .yAxisTitle("Height of Tree")
        .build();


    chart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Scatter);

    chart.addSeries("Height vs Time", ti, hi).setMarker(SeriesMarkers.CIRCLE);

    // Show it
    new SwingWrapper(chart).displayChart();

    BitmapEncoder.saveBitmapWithDPI(chart, "./BSTGraph", BitmapFormat.PNG, 300);






}






}


