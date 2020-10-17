package com.dqpi.algo.vm;

import com.dqpi.algo.enums.AlgoEnum;
import com.dqpi.algo.sort.SortData;
import com.dqpi.algo.view.MainView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;

import javax.annotation.Resource;

/**
 * @author Mountain
 * @date 2020/10/13
 */
@FXMLController
public class MainVm  {
    
    @Resource
    private SortData sortData;
    
    @Resource
    private MainView mainView;
    
    private boolean isInit;
    
    public int getSize() {
        ChoiceBox<String> sizeList = (ChoiceBox<String>) mainView.getView().lookup("#sizeList");
        String item = sizeList.getSelectionModel().getSelectedItem();
        if ("数量选择".equals(item)) {
            return 0;
        }
        return Integer.parseInt(item);
    }

    public void setInitShow(boolean isShow) {
        Button button = (Button) mainView.getView().lookup("#init");
        button.setDisable(!isShow);
    }
    
    public void setStartShow(boolean isShow) {
        Button button = (Button) mainView.getView().lookup("#start");
        button.setDisable(!isShow);
    }
    
    public int getSelectAlgo() {
        ChoiceBox<String> sortList = (ChoiceBox<String>) mainView.getView().lookup("#sortList");
        return sortList.getSelectionModel().getSelectedIndex();
    }
    
    public void init(MouseEvent event) {
        if (!isInit) {
            isInit = true;
        }
        sortData.initNumbers();
    }

    public void start(MouseEvent event) {
        if (isInit) {
            int select = getSelectAlgo();
            if (select == 0) {
                return;
            }

            setInitShow(false);
            setStartShow(false);
            sortData.sort(AlgoEnum.getAlgo(select));
        }
    }
}
