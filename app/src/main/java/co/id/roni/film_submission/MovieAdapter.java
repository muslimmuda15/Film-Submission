package co.id.roni.film_submission;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private ArrayList<MovieModel> movieData = new ArrayList<>();

    public void setMovieData(ArrayList<MovieModel> movies) {
        movieData.clear();
        movieData.addAll(movies);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovieViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.bind(movieData.get(position));
    }

    @Override
    public int getItemCount() {
        return movieData.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        private TextView tvMovieTitle;
        private TextView tvOverview;
        private TextView tvMovieRate;
        private ImageView imgMoviePoster;

        MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMovieTitle = itemView.findViewById(R.id.tv_title_movie_item);
            tvOverview = itemView.findViewById(R.id.tv_overview_item);
            tvMovieRate = itemView.findViewById(R.id.tv_rate_average);
            imgMoviePoster = itemView.findViewById(R.id.img_poster_item);
        }
        void bind(MovieModel movies){
            tvMovieTitle.setText(movies.getTitle());
            tvOverview.setText(movies.getOverview());
            tvMovieRate.setText(String.valueOf(movies.getVote_average()));
            Glide.with(itemView.getContext()).load(movies.getPoster_path()).into(imgMoviePoster);
        }
    }
}
