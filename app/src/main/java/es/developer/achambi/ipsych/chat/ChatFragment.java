package es.developer.achambi.ipsych.chat;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import es.developer.achambi.coreframework.ui.BaseSearchListFragment;
import es.developer.achambi.coreframework.ui.Presenter;
import es.developer.achambi.coreframework.ui.SearchAdapterDecorator;
import es.developer.achambi.ipsych.R;

public class ChatFragment extends BaseSearchListFragment implements ValueEventListener {
    private ChatAdapter adapter;
    private ChatPresenter presenter;
    private TextView chatEditText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle( getTitleResource() );
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public int getLayoutResource() {
        return R.layout.chat_fragment_layout;
    }

    @Override
    public Presenter setupPresenter() {
        if( presenter == null ) {
            presenter = new ChatPresenter();
        }
        return presenter;
    }

    public static ChatFragment newInstance() {
        return new ChatFragment();
    }

    @Override
    public void onViewSetup(View view, @Nullable Bundle savedInstanceState) {
        super.onViewSetup(view, savedInstanceState);

        view.findViewById( R.id.chat_send_button ).setOnClickListener( this );
        chatEditText = view.findViewById( R.id.chat_edit_text );
        FirebaseDatabase.getInstance().getReference().addValueEventListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if( v.getId() == R.id.chat_send_button ) {
            presenter.pushChatMessage( chatEditText.getText().toString() );
            chatEditText.setText("");
        }
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

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        ArrayList<ChatMessagePresentation> chatMessages = new ArrayList<>();
        for (DataSnapshot item : dataSnapshot.getChildren()) {
            chatMessages.add( ChatMessagePresentation.Builder.buildPresentation(
                    getActivity(),
                    FirebaseAuth.getInstance().getCurrentUser().getDisplayName(),
                    item.getValue(ChatMessage.class) ) );
        }
        adapter.setData( chatMessages );
        presentAdapterData();
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.e(ChatFragment.class.getName(), databaseError.getMessage());
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
