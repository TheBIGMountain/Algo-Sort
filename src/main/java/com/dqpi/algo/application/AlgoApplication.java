package com.dqpi.algo.application;

import com.dqpi.algo.config.PaneConfig;
import com.dqpi.algo.view.MainView;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author TheBIGMountain
 */
@EnableAsync
@SpringBootApplication
@ComponentScan("com.dqpi.algo")
public class AlgoApplication extends AbstractJavaFxApplicationSupport {
    
    public static void start(String[] args) {
        launch(AlgoApplication.class, MainView.class, args);
    }

    @Override
    public void beforeInitialView(Stage stage, ConfigurableApplicationContext ctx) {
        super.beforeInitialView(stage, ctx);
        MainView mainView = ctx.getBean(MainView.class);
        PaneConfig paneConfig = ctx.getBean(PaneConfig.class);
        
        Pane pane = (Pane) mainView.getView();
        pane.prefWidth(paneConfig.getWidth());
        pane.prefHeight(paneConfig.getHeight());

        ChoiceBox<String> sortList = (ChoiceBox<String>) pane.lookup("#sortList");
        sortList.setTooltip(new Tooltip("算法选择"));
        sortList.getSelectionModel().select(0);

        ChoiceBox<String> sizeList = (ChoiceBox<String>) pane.lookup("#sizeList");
        sizeList.setTooltip(new Tooltip("数量选择"));
        sizeList.getSelectionModel().select(0);

        ChoiceBox<String> speedList = (ChoiceBox<String>) pane.lookup("#speedList");
        speedList.setTooltip(new Tooltip("速度选择"));
        speedList.getSelectionModel().select(0);

        ChoiceBox<String> sortStatusList = (ChoiceBox<String>) pane.lookup("#sortStatusList");
        sortStatusList.setTooltip(new Tooltip("分布情况"));
        sortStatusList.getSelectionModel().select(0);

        Button copyCode = (Button) pane.lookup("#copyCode");
        Tooltip tooltip = new Tooltip();
        tooltip.setText("请选择算法");
        tooltip.setStyle("-fx-font-size: 14");
        copyCode.setTooltip(tooltip);

        stage.setTitle("排序算法");
        stage.setResizable(false);
        stage.initStyle(StageStyle.UTILITY);
        stage.setOnCloseRequest(event ->  System.exit(0) );
    }
}
