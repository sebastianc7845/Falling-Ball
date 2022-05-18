package ballDemo;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class BallDemo extends Application {
	private static final int RADIUS = 15;
	private static final int MAX_X = 640;
	private static final int MAX_Y = 480;
	private static final double g = 4.9;
	private double startX = 0.0;
	private double startY = 0.0;
	

    @Override
    public void start(Stage stage) {
        Circle ball = new Circle(RADIUS);
        StackPane pane = new StackPane(ball);
        Scene scene = new Scene(pane, MAX_X, MAX_Y);
        
        ball.setOnMousePressed(mouseEvent -> {
        	double mouseX = mouseEvent.getSceneX(), mouseY = mouseEvent.getSceneY();
        	
        	startX = mouseX - ball.getTranslateX();
        	startY = mouseY - ball.getTranslateY();
        	
        	System.out.println("Mouse entered: (" + mouseX + ", " + mouseY + ")");
        	System.out.println("Ball coords: (" + ball.getTranslateX()+ ", " + ball.getTranslateY() + ")");
        });
        
        ball.setOnMouseDragged(mouseEvent -> {
        	double mouseX = mouseEvent.getSceneX(), mouseY = mouseEvent.getSceneY();
        	
        	ball.setTranslateX(mouseX - startX);
        	ball.setTranslateY(mouseY - startY);
        	
        	System.out.println("Mouse moved: (" + mouseX + ", " + mouseY + ")");
        	System.out.println("Ball coords: " + ball.getTranslateX()+ ", " + ball.getTranslateY() + ")");
        });
        
        ball.setOnMouseReleased(mouseEvent -> {
        	System.out.println("Ball released");
        	int t = 0;
        });
        
        
        stage.setTitle("Ball Demo");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
