package Adapter;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalprojectquizapp.DatabaseHelper;
import com.example.finalprojectquizapp.R;

public class CatagoryAdapter extends RecyclerView.Adapter<CatagoryAdapter.CatagoryViewHolder> {

    private Context context;
    private Cursor cursor;
    private OnItemClickListener listener;

    // Interface for item click listener
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    // Set the click listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    // Constructor
    public CatagoryAdapter(Context context, Cursor cursor) {
        this.context = context;
        this.cursor = cursor;
    }

    @NonNull
    @Override
    public CatagoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.catagory_custom, parent, false);
        return new CatagoryViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull CatagoryViewHolder holder, int position) {
        if (cursor != null && cursor.moveToPosition(position)) {
            // Get data from cursor
            String name = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_CATEGORY_NAME));
            byte[] imageByteArray = cursor.getBlob(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_CATEGORY_IMAGE_URI));

            // Convert byte array to bitmap
            Bitmap bitmap = BitmapFactory.decodeByteArray(imageByteArray, 0, imageByteArray.length);

            // Set data to views
            holder.catagoryImageView.setImageBitmap(bitmap);
            holder.nameTextView.setText(name);
        }
    }

    @Override
    public int getItemCount() {
        return cursor == null ? 0 : cursor.getCount();
    }

    // ViewHolder Class
    static class CatagoryViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        ImageView catagoryImageView;

        public CatagoryViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.tv_Catagory_Name);
            catagoryImageView = itemView.findViewById(R.id.iv_catagory_image);

            // Set click listener for the entire item
            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                }
            });
        }
    }
}