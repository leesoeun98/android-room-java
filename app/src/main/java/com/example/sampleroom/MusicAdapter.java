package com.example.sampleroom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder> {

    private List<Music> musicList;

    public MusicAdapter(List<Music> list) {
        musicList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.item_music, parent, false);
        MusicAdapter.ViewHolder vh = new MusicAdapter.ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Music item = musicList.get(position);
        holder.title.setText(item.title);
        holder.singer.setText(item.singer);
        holder.playTime.setText(Long.toString(item.playTime));
        holder.lyrics.setText(item.lyrics);
    }

    @Override
    public int getItemCount() {
        return musicList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView singer;
        TextView playTime;
        TextView lyrics;

        ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.itemTitle);
            singer = itemView.findViewById(R.id.itemSinger);
            playTime=itemView.findViewById(R.id.itemPlayTime);
            lyrics = itemView.findViewById(R.id.itemLyrics);
        }
    }
}
