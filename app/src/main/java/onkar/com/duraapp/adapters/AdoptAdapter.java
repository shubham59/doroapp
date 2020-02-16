package onkar.com.duraapp.adapters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import onkar.com.duraapp.R;

public class AdoptAdapter extends RecyclerView.Adapter<AdoptAdapter.AdoptViewHolder> {

    private AdapterClickListener listener;

    public AdoptAdapter(AdapterClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public AdoptViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_rv_adopt, parent, false);
        return new AdoptViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdoptViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class AdoptViewHolder extends RecyclerView.ViewHolder{

        public AdoptViewHolder(View itemView) {
            super(itemView);
        }
    }
}
