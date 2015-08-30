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
    private static final int TYPE_ITEM = 1;

    private String[] titles;
    private int[] icons;
    private String name;
    private int profile;
    private String email;


    public NavigationAdapter(String[] titles, int[] icons, String name, String email, int profile) {
        this.titles = titles;
        this.icons = icons;
        this.profile = profile;
        this.name = name;
        this.email = email;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row_navigation_drawer, parent, false);
            ViewHolder viewHolder = new ViewHolder(view, viewType);
            return viewHolder;
        } else if (viewType == TYPE_HEADER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_navigation_drawer, parent, false);
            ViewHolder viewHolder = new ViewHolder(view, viewType);
            return viewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (holder.Holderid == 1) {
            holder.textView.setText(titles[position - 1]);
            holder.imageView.setImageResource(icons[position - 1]);
        }else{
           holder.profile.setImageResource(profile);
            holder.name.setText(name);
            holder.email.setText(email);
        }
    }

    @Override
    public int getItemCount() {
        return titles.length+1;
    }

    @Override
    public int getItemViewType(int position) {
        if(isHeader(position)){
            return  TYPE_HEADER;
        }else {
            return TYPE_ITEM;
        }
    }

    private boolean isHeader(int position){
        return position == 0;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {

        int Holderid;
        TextView textView;
        ImageView imageView;
        ImageView profile;
        TextView name;
        TextView email;

        public ViewHolder(View itemView, int viewType) {
            super(itemView);

            if (viewType == TYPE_ITEM) {
                textView = (TextView) itemView.findViewById(R.id.rowText);
                imageView = (ImageView) itemView.findViewById(R.id.rowIcon);
                Holderid = 1;

            } else {
                name = (TextView) itemView.findViewById(R.id.name);
                email = (TextView) itemView.findViewById(R.id.name);
                profile = (ImageView) itemView.findViewById(R.id.circleImageView);
                Holderid = 0;
            }
        }
    }
}
