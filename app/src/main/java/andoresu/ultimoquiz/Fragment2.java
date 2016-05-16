package andoresu.ultimoquiz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import andoresu.ultimoquiz.eventBus.MessageData;
import andoresu.ultimoquiz.eventBus.MessageSubmit;

/**
 * Created by dell on 16/05/2016.
 */
public class Fragment2 extends Fragment {

    EditText nameET, lastNameET;

    public Fragment2() {
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_fragment2, container, false);
        nameET = (EditText) v.findViewById(R.id.nameTv);
        lastNameET = (EditText) v.findViewById(R.id.lastNameTv);

        return v;
    }

    @Subscribe
    public void onMessageEvent(MessageSubmit event){
        MessageData messageData = new MessageData(nameET.getText().toString(), lastNameET.getText().toString());
        EventBus.getDefault().post(messageData);
    }
}
