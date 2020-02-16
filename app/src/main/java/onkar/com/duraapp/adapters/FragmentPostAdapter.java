package onkar.com.duraapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import onkar.com.duraapp.R;
import onkar.com.duraapp.model.OwnModel;

public class FragmentPostAdapter extends RecyclerView.Adapter<FragmentPostAdapter.FragmentPostHolder> {

    List<OwnModel> list;

    public FragmentPostAdapter(List<OwnModel> list){
        this.list = list;
    }

    @NonNull
    @Override
    public FragmentPostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_post_give, parent, false);
        return new FragmentPostHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FragmentPostHolder holder, int position) {
        holder.tvName.setText(list.get(position).getName());
        holder.tvAge.setText(list.get(position).getAge());
        holder.tvBreed.setText(list.get(position).getBreed());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class FragmentPostHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvAge, tvBreed;

        public FragmentPostHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.textView3);
            tvAge = itemView.findViewById(R.id.textView4);
            tvBreed = itemView.findViewById(R.id.textView5);
        }
    }
}
