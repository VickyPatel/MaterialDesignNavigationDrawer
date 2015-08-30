package vickypatel.ca.materialdesignnavigationdrawer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by VickyPatel on 2015-08-29.
 */
public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM1 = 1;
    private static final int TYPE_ITEM2 = 2;

    private String[] titles;
    private String[] titles2;
    private int[] icons;
    private String name;
    private int profile;
    private String email;


    public NavigationAdapter(String[] titles, String[] titles2, int[] icons, String name, String email, int profile) {
        this.titles = titles;
        this.titles2 = titles2;
        this.icons = icons;
        this.profile = profile;
        this.name = name;
        this.email = email;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder = null;
        if (viewType == TYPE_ITEM1) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row_navigation_drawer, parent, false);
            viewHolder = new ViewHolder(view, viewType);

        } else if (viewType == TYPE_HEADER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_navigation_drawer, parent, false);
            viewHolder = new ViewHolder(view, viewType);

        } else if (viewType == TYPE_ITEM2) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row_navigation_drawer, parent, false);
            viewHolder = new ViewHolder(view, viewType);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (holder.Holderid == 1) {
            holder.textView.setText(titles[position - 1]);
            holder.imageView.setImageResource(icons[position - 1]);
        } else if (holder.Holderid == 2) {
            holder.textView2.setText(titles2[position - 5]);
            holder.imageView2.setImageResource(icons[position - 5]);
        } else if(holder.Holderid == 0){
            holder.profile.setImageResource(profile);
            holder.name.setText(name);
            holder.email.setText(email);
        }
    }

    @Override
    public int getItemCount() {
        return 1 + titles.length  + titles2.length;
    }

    @Override
    public int getItemViewType(int position) {
        int currentPosition = 0;
        if (position == 0) {
            currentPosition = TYPE_HEADER;
        } else if (position >= 1 && position < 5) {
            currentPosition = TYPE_ITEM1;
        } else if(position >= 5){
            currentPosition = TYPE_ITEM2;
        }
        return  currentPosition;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        int Holderid;
        TextView textView;
        ImageView imageView;
        TextView textView2;
        ImageView imageView2;
        ImageView profile;
        TextView name;
        TextView email;

        public ViewHolder(View itemView, int viewType) {
            super(itemView);

            if (viewType == TYPE_ITEM1) {
                textView = (TextView) itemView.findViewById(R.id.rowText);
                imageView = (ImageView) itemView.findViewById(R.id.rowIcon);
                Holderid = 1;
            } else if (viewType == TYPE_ITEM2) {
                textView2 = (TextView) itemView.findViewById(R.id.rowText);
                imageView2 = (ImageView) itemView.findViewById(R.id.rowIcon);
                Holderid = 2;
            } else if(viewType == TYPE_HEADER) {
                name = (TextView) itemView.findViewById(R.id.name);
                email = (TextView) itemView.findViewById(R.id.email);
                profile = (ImageView) itemView.findViewById(R.id.circleImageView);
                Holderid = 0;
            }
        }
    }
}
