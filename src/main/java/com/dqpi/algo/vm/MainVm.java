package com.dqpi.algo.vm;

import com.dqpi.algo.enums.AlgoEnum;
import com.dqpi.algo.sort.SortData;
import com.dqpi.algo.sort_code.SortCode;
import com.dqpi.algo.view.MainView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.Clipboard;
import javafx.scene.input.DataFormat;
import javafx.scene.input.MouseEvent;

import javax.annotation.Resource;
import java.util.HashMap;

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
    
    @Resource
    private SortCode code;
    
    private final HashMap<DataFormat, Object> map = new HashMap<>();
    
    private boolean isInit;
    
    public int getSize() {
        ChoiceBox<String> sizeList = (ChoiceBox<String>) mainView.getView().lookup("#sizeList");
        String item = sizeList.getSelectionModel().getSelectedItem();
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
            setInitShow(false);
            setStartShow(false);
            sortData.sort(AlgoEnum.getAlgo(getSelectAlgo()));
        }
    }

    public void showCode(MouseEvent event) {
        Button copyCode = (Button) mainView.getView().lookup("#copyCode");
        copyCode.getTooltip().setText(code.getCode(AlgoEnum.getAlgo(getSelectAlgo()), getSize()));
    }

    public void copy(MouseEvent event) {
        map.put(DataFormat.PLAIN_TEXT, code.getCode(AlgoEnum.getAlgo(getSelectAlgo()), getSize()));
        Clipboard.getSystemClipboard().setContent(map);
    }
    
    public int getSortStatus() {
        ChoiceBox<String> speedList = (ChoiceBox<String>) mainView.getView().lookup("#sortStatusList");
        return speedList.getSelectionModel().getSelectedIndex();
    }
    
    public int getDelay() {
        ChoiceBox<String> speedList = (ChoiceBox<String>) mainView.getView().lookup("#speedList");
        return 25 - speedList.getSelectionModel().getSelectedIndex() * 5;
    }
}