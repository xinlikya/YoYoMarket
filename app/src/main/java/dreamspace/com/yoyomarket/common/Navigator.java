package dreamspace.com.yoyomarket.common;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.HashMap;

import javax.inject.Inject;
import javax.inject.Singleton;

import dreamspace.com.yoyomarket.api.entity.element.AddressInfo;
import dreamspace.com.yoyomarket.api.entity.element.GoodInfo;
import dreamspace.com.yoyomarket.common.base.BaseActivity;
import dreamspace.com.yoyomarket.ui.views.activity.AddressActivity;
import dreamspace.com.yoyomarket.ui.views.activity.AllCommentsActivity;
import dreamspace.com.yoyomarket.ui.views.activity.FeedbackActivity;
import dreamspace.com.yoyomarket.ui.views.activity.LoginActivity;
import dreamspace.com.yoyomarket.ui.views.activity.MainActivity;
import dreamspace.com.yoyomarket.ui.views.activity.ModifyAddressActivity;
import dreamspace.com.yoyomarket.ui.views.activity.ModifyPwdActivity;
import dreamspace.com.yoyomarket.ui.views.activity.OrderInfoActivity;
import dreamspace.com.yoyomarket.ui.views.activity.PayOrderActivity;
import dreamspace.com.yoyomarket.ui.views.activity.PickGoodsActivity;
import dreamspace.com.yoyomarket.ui.views.activity.RegisterActivity;
import dreamspace.com.yoyomarket.ui.views.activity.SearchGoodActivity;
import dreamspace.com.yoyomarket.ui.views.activity.ShopInfoActivity;

/**
 * Created by Lx on 2016/1/26.
 */
@Singleton
public class Navigator {

    @Inject
    public Navigator(){}

    public void navigateToMainActivity(@NonNull Context context){
        Intent intent = MainActivity.getCallingIntent(context);
        context.startActivity(intent);
    }

    public void navigateToLoginActivity(@NonNull Context context){
        Intent intent = LoginActivity.getCallingIntent(context);
        context.startActivity(intent);
    }

    public void navigateToRegisterActivity(@NonNull Context context){
        Intent intent = RegisterActivity.getCallingIntent(context);
        context.startActivity(intent);
    }

    public void navigateToModifyPwdActivity(@NonNull Context context,int mode){
        Intent intent = ModifyPwdActivity.getCallingIntent(context,mode);
        context.startActivity(intent);
    }

    public void navigateToAddressActivity(@NonNull BaseActivity context,int requestCode,int mode){
        Intent intent = AddressActivity.getCallingIntent(context,mode);
        if(mode == AddressActivity.PICK_ADDRESS){
            context.startActivityForResult(intent,requestCode);
        }else{
            context.startActivity(intent);
        }
    }

    public void navigateToModifyAddressActivity(@NonNull BaseActivity context, int mode,int requestCode,@Nullable String addressId,@Nullable AddressInfo addressInfo){
        Intent intent = ModifyAddressActivity.getCallingIntent(context,mode,addressId,addressInfo);
        context.startActivityForResult(intent, requestCode);
    }

    public void navigateToFeedbackActivity(@NonNull Context context){
        Intent intent = FeedbackActivity.getCallingIntent(context);
        context.startActivity(intent);
    }

    public void navigateToPickGoodsActivity(@NonNull Context context,String supId,String supName){
        Intent intent = PickGoodsActivity.getCallingIntent(context,supId,supName);
        context.startActivity(intent);
    }

    public void navigateToShopInfoActivity(@NonNull Context context){
        Intent intent = ShopInfoActivity.getCallingIntent(context);
        context.startActivity(intent);
    }

    public void navigateToAllCommentsActivity(@NonNull Context context){
        Intent intent = AllCommentsActivity.getCallingIntent(context);
        context.startActivity(intent);
    }

    public void navigateToSearchGoodActivity(@NonNull BaseActivity context, int requestCode, String supId, HashMap<String, GoodInfo> pickGoods){
        Intent intent = SearchGoodActivity.getCallingIntent(context,supId,pickGoods);
        context.startActivityForResult(intent, requestCode);
    }

    public void navigateToPayOrderActivity(@NonNull Context context,String supId,HashMap<String,GoodInfo> pickGoods){
        Intent intent = PayOrderActivity.getCallingIntent(context,supId,pickGoods);
        context.startActivity(intent);
    }

    public void navigateToOrderInfoActivity(@NonNull Context context,String orderId){
        Intent intent = OrderInfoActivity.getCallingIntent(context,orderId);
        context.startActivity(intent);
    }
}
