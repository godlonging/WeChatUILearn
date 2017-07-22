package com.apps.animaljie.wechatui;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/**
 * Created by animaljie on 2017/7/22.
 */

public class ActionProvider extends android.view.ActionProvider{
    /**
     * Creates a new instance.
     *
     * @param context Context for accessing resources.
     */
    public ActionProvider(Context context) {
        super(context);
    }

    @Override
    public View onCreateActionView() {
        return null;
    }

    @Override
    public void onPrepareSubMenu(SubMenu subMenu) {
        subMenu.clear();
        subMenu.add("扫一扫").setIcon(R.drawable.men_scan_icon).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return true;
            }
        });
        subMenu.add("添加朋友").setIcon(R.drawable.menu_add_icon).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return true;
            }
        });
    }

    @Override
    public boolean hasSubMenu() {
        return true;
    }
}
