package me.nunum.whereami.adapters;

import android.support.annotation.NonNull;
import android.support.v7.util.SortedList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.List;

import me.nunum.whereami.R;
import me.nunum.whereami.fragments.TrainingStatusFragment;
import me.nunum.whereami.framework.OnListSizeChange;
import me.nunum.whereami.framework.SortedListCallbackImpl;
import me.nunum.whereami.model.TrainingProgress;

public class TrainingRecyclerViewAdapter extends RecyclerView.Adapter<TrainingRecyclerViewAdapter.ViewHolder> {

    private final SortedList<TrainingProgress> mValues;
    private OnListSizeChange mSizeListener;
    private boolean canDelete;
    private TrainingStatusFragment.OnFragmentInteractionListener mListener;

    public TrainingRecyclerViewAdapter(TrainingStatusFragment.OnFragmentInteractionListener listener, boolean canDelete) {
        this.mValues = new SortedList<>(TrainingProgress.class, new SortedListCallbackImpl<TrainingProgress>(this));
        this.mListener = listener;
        this.canDelete = canDelete;
    }

    public void addAll(List<TrainingProgress> positions) {
        this.mValues.beginBatchedUpdates();
        for (int i = 0; i < positions.size(); i++) {
            this.mValues.add(positions.get(i));
        }
        this.mValues.endBatchedUpdates();

        if (mSizeListener != null) {
            mSizeListener.currentSize(mValues.size());
        }
    }

    @NonNull
    @Override
    public TrainingRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_training_list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.mAlgorithmName.setText(holder.mItem.getAlgorithmName().toUpperCase());
        holder.mTrainingStatus.setText(String.format("STATUS: %s.  LAST UPDATE: %s", holder.mItem.getStatus().toUpperCase(), holder.mItem.prettyDate()));

        if (!canDelete) {
            holder.mIdTrainingOptionsMenu.setVisibility(View.INVISIBLE);
        } else {
            holder.mIdTrainingOptionsMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    PopupMenu popupMenu = new PopupMenu(mListener.context(), holder.mIdTrainingOptionsMenu);

                    popupMenu.inflate(R.menu.ftli_training_options_menu);

                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {

                            switch (menuItem.getItemId()) {
                                case R.id.ftli_delete_training_request:
                                    break;
                            }

                            return false;
                        }
                    });

                    popupMenu.show();
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        public TextView mAlgorithmName;
        public TextView mTrainingStatus;
        public Button mIdTrainingOptionsMenu;
        public TrainingProgress mItem;


        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            mAlgorithmName = itemView.findViewById(R.id.ftli_algorithm_display_name);
            mTrainingStatus = itemView.findViewById(R.id.ftli_training_status);
            mIdTrainingOptionsMenu = itemView.findViewById(R.id.ftli_training_item_options);
        }
    }
}