package es.developer.achambi.ipsych.chat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import es.developer.achambi.coreframework.ui.BaseSearchListFragment;
import es.developer.achambi.coreframework.ui.SearchAdapterDecorator;
import es.developer.achambi.ipsych.R;

public class ChatFragment extends BaseSearchListFragment {
    private ChatAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle( getTitleResource() );
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public static ChatFragment newInstance() {
        return new ChatFragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<ChatMessagePresentation> data = new ArrayList<>();
        data.add( new ChatMessagePresentation( 0, "pepe", "12-Dic",
                "gflkdajgfkldgjfdlsñgjfdklsgjfsdlgjfdskjgsdf", true ) );
        data.add( new ChatMessagePresentation( 1, "aaaa", "12-Dic",
                "gflkdajgfkldgjfdlsñgjfdklsgjfsdlgjfdskjgsdf", false ) );
        data.add( new ChatMessagePresentation( 2, "pepe", "12-Dic",
                "gflkdajgfkldgjfdlsñgjfdklsgjfsdlgjfdskjgsdf", true ) );
        data.add( new ChatMessagePresentation( 3, "aaaa", "12-Dic",
                "gflkdajgfkldgjfdlsñgjfdklsgjfsdlgjfdskjgsdf", false ) );

        adapter.setData( data );
        presentAdapterData();
    }

    @Override
    public SearchAdapterDecorator provideAdapter() {
        if( adapter == null ) {
            adapter = new ChatAdapter();
        }
        return adapter;
    }

    public int getTitleResource() {
        return R.string.chat_activity_title;
    }

    private class ChatMessageViewHolder extends RecyclerView.ViewHolder {
        private TextView userName;
        private TextView dateText;
        private TextView message;

        ChatMessageViewHolder(View itemView) {
            super(itemView);
        }

        public void linkTo() {
            userName = itemView.findViewById( R.id.chat_bubble_name_text );
            dateText = itemView.findViewById( R.id.chat_bubble_message_time_text );
            message = itemView.findViewById( R.id.chat_bubble_message_text );
        }

        public void bindTo(ChatMessagePresentation presentation ) {
            userName.setText( presentation.userName );
            dateText.setText( presentation.timestamp );
            message.setText( presentation.message );
            if( presentation.ownMessage ) {
                userName.setVisibility(View.GONE);
                itemView.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
                itemView.setBackground(ContextCompat.getDrawable(getActivity(),
                        R.drawable.chat_bubble_background_right));
            } else {
                userName.setVisibility(View.VISIBLE);
                itemView.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
                itemView.setBackground(ContextCompat.getDrawable(getActivity(),
                        R.drawable.chat_bubble_background_left));
            }
        }
    }

    public class ChatAdapter extends SearchAdapterDecorator<ChatMessagePresentation,
                ChatMessageViewHolder> {

        @Override
        public int getLayoutResource() {
            return R.layout.chat_bubble_layout;
        }

        @Override
        public ChatMessageViewHolder createViewHolder(View rootView) {
            ChatMessageViewHolder viewHolder = new ChatMessageViewHolder( rootView );
            viewHolder.linkTo( );
            return viewHolder;
        }

        @Override
        public void bindViewHolder(ChatMessageViewHolder holder, ChatMessagePresentation item) {
            holder.bindTo( item );
        }


        @Override
        public int getAdapterViewType() {
            return R.id.chat_bubble_id;
        }
    }
}
