package andoresu.ultimoquiz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import andoresu.ultimoquiz.eventBus.MessageData;
import andoresu.ultimoquiz.eventBus.MessageSubmit;


public class Fragment3 extends Fragment {

    Button submitBtn;
    MessageData messageData;

    public Fragment3() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment3, container, false);

        submitBtn = (Button) v.findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new MessageSubmit("nuevo click"));
            }
        });

        return v;
    }


}

