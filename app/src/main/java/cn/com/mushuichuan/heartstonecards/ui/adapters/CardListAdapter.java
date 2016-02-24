package cn.com.mushuichuan.heartstonecards.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import cn.com.mushuichuan.heartstonecards.R;
import cn.com.mushuichuan.heartstonecards.mvp.model.Card;

import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableList;

/**
 * Created by Liyanshun on 2016/2/22.
 */
public class CardListAdapter extends RecyclerView.Adapter<CardListViewHolder> {
    private final Picasso picasso;
    private final LayoutInflater layoutInflater;
    private List<Card> items = emptyList();

    @Inject
    public CardListAdapter(Picasso picasso, LayoutInflater layoutInflater) {
        this.picasso = picasso;
        this.layoutInflater = layoutInflater;
    }

    public void setData(List<Card> items) {
        this.items = unmodifiableList(items);
        notifyDataSetChanged();
    }

    @Override
    public CardListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CardListViewHolder(layoutInflater.inflate(R.layout.class_list_item, null), picasso);
    }

    @Override
    public void onBindViewHolder(CardListViewHolder holder, int position) {
        holder.bindItem(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
