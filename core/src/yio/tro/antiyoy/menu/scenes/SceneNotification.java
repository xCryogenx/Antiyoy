package yio.tro.antiyoy.menu.scenes;

import yio.tro.antiyoy.menu.ButtonYio;
import yio.tro.antiyoy.menu.MenuControllerYio;
import yio.tro.antiyoy.stuff.LanguagesManager;

public class SceneNotification extends AbstractScene{


    public SceneNotification(MenuControllerYio menuControllerYio) {
        super(menuControllerYio);
    }


    public void showNotification(String messageKey, boolean autoHide) {
        ButtonYio notificationButton = buttonFactory.getButton(generateRectangle(0, 0.95, 1, 0.05), 3614, null);
        notificationButton.setTextLine(LanguagesManager.getInstance().getString(messageKey));
        menuControllerYio.getButtonRenderer().renderButton(notificationButton);
        notificationButton.setAnimType(ButtonYio.ANIM_UP);
        notificationButton.enableRectangularMask();
        notificationButton.setTouchable(false);
        notificationButton.appearFactor.beginSpawning(3, 1);
        notificationButton.setShadow(false);

        menuControllerYio.removeInterfaceElementFromArray(notificationButton);
        menuControllerYio.addMenuBlockToArray(notificationButton);

        menuControllerYio.notificationHolder.setButton(notificationButton);
        menuControllerYio.notificationHolder.setAutoHide(autoHide);
    }


    public void hideNotification() {
        ButtonYio notificationButton = menuControllerYio.getButtonById(3614);
        if (notificationButton == null) return;
        notificationButton.destroy();
        notificationButton.appearFactor.beginDestroying(1, 3);
    }


    public boolean notificationIsDestroying() {
        ButtonYio notificationButton = menuControllerYio.getButtonById(3614);
        if (notificationButton == null) return false;
        if (notificationButton.appearFactor.getGravity() < 0) return true;
        return false;
    }


    @Override
    public void create() {

    }
}