package move.the.ball;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
/**
 *
 * @author Seif
 */
public class MoveTheBall extends Application {
       //creating a pane for the ball
	private BallPane ballPane = new BallPane();

	@Override // Overriding the start method in the Application class
	public void start(Stage primaryStage) {
		// creating an HBox and four buttons in it
		HBox hBox = new HBox(5);
		hBox.setAlignment(Pos.CENTER); // aliging it in the center
		Button btLeft = new Button("Left");// creating the left button
		Button btRight = new Button("Right");//creating the right button
		Button btUp = new Button("Up");// creating the up button
		Button btDown = new Button("Down");// creating the down button
		hBox.getChildren().addAll(btLeft, btRight, btUp, btDown);//adding them to the Hbox
		// adding functions to the buttons
		btLeft.setOnAction(e -> ballPane.moveLeft());
		btRight.setOnAction(e -> ballPane.moveRight());
		btUp.setOnAction(e -> ballPane.moveUp());
		btDown.setOnAction(e -> ballPane.moveDown());
		// Creating a border for the pane
		BorderPane pane = new BorderPane(); //creating new border pane
		pane.setPadding(new Insets(10, 10, 10, 10)); //adding border coordinations
		pane.setCenter(ballPane);//asigning it to the ballpane
		pane.setBottom(hBox);

		// Creating a scene and placing it in the stage
		Scene scene = new Scene(pane, 250, 250);
		primaryStage.setTitle("Move The Ball"); // choosing the stage title
		primaryStage.setScene(scene); // Placing the scene in the stage
		primaryStage.show(); // Displaying the stage
    }
 //the ballpane class
private class BallPane extends Pane {
 //defining the circle
        private Circle mCircle;
//adding ballpane coordinations
        public BallPane() {
            this(100, 100, 30);
        }
        //creating the circle with the coordinations
        public BallPane(double X, double Y, double radius) {
            mCircle = new Circle(X, Y, radius);
            getChildren().add(mCircle);//adding the circle to the pane
        }
//function to move the circle up  
        public void moveUp() {
            if (mCircle.getCenterY() - mCircle.getRadius()  - 10 < 0) 
                return;
            mCircle.setCenterY(mCircle.getCenterY() - 10);
        }
        // function to move the circle down
        public void moveDown() {
            if (mCircle.getCenterY() + mCircle.getRadius() + 10 > getHeight())
                return;

            mCircle.setCenterY(mCircle.getCenterY() + 10);
        }
        //function to move the circle right
        public void moveRight() {
            if (mCircle.getCenterX() + mCircle.getRadius() + 10 > getWidth()) 
                return;
            mCircle.setCenterX(mCircle.getCenterX() + 10);
        }
        //function to move the circle left
        public void moveLeft() {
            if (mCircle.getCenterX() - mCircle.getRadius()  - 10 < 0) return;
            mCircle.setCenterX(mCircle.getCenterX() - 10);

        }
    }
    public static void main(String[] args) {
        Application.launch(args);
    }   
}
