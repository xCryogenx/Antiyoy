package yio.tro.antiyoy.menu;

import yio.tro.antiyoy.stuff.RectangleYio;

/**
 * Created by ivan on 22.07.14.
 */
public class ButtonFactory {
    private final MenuControllerYio menuControllerYio;
    private final ButtonRenderer buttonRenderer;


    public ButtonFactory(MenuControllerYio menuControllerYio) {
        this.menuControllerYio = menuControllerYio;
        buttonRenderer = new ButtonRenderer();
    }


    public ButtonYio getButton(RectangleYio position, int id, String text) {
        ButtonYio buttonYio = menuControllerYio.getButtonById(id);
        if (buttonYio == null) { // if it's the first time
            buttonYio = new ButtonYio(position, id, menuControllerYio);
            if (text != null) {
                buttonYio.addTextLine(text);
                buttonRenderer.renderButton(buttonYio);
            }
            menuControllerYio.addMenuBlockToArray(buttonYio);
        }
        buttonYio.setVisible(true);
        buttonYio.setTouchable(true);
        buttonYio.appearFactor.beginSpawning(MenuControllerYio.SPAWN_ANIM, MenuControllerYio.SPAWN_SPEED);
        buttonYio.appearFactor.setValues(0, 0.001);
        buttonYio.touchAnimation = true;
        return buttonYio;
    }
}
