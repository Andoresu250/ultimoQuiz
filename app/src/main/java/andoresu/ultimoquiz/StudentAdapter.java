package andoresu.ultimoquiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dell on 16/05/2016.
 */
public class StudentAdapter extends BaseAdapter{

    private List<Student> studentList;
    private Context context;

    public StudentAdapter(Context context,List<Student> studentList) {
        this.studentList = studentList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Object getItem(int position) {
        return studentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if(view == null){
            LayoutInflater inflater = (LayoutInflater)context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.row_student, null);
        }

        TextView nameStudent = (TextView) view.findViewById(R.id.studentNameTV);
        nameStudent.setText(studentList.get(position).getFullName());
        return view;
    }
}
