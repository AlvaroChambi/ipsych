package es.developer.achambi.ipsych.chat;

import android.support.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

import es.developer.achambi.coreframework.threading.Request;
import es.developer.achambi.coreframework.threading.Response;
import es.developer.achambi.coreframework.ui.Presenter;

public class ChatPresenter extends Presenter {
    public void pushChatMessage( final String message ) {
        DatabaseReference dbReference = FirebaseDatabase.getInstance().getReference();
        Date timestamp = new Date();
        dbReference.push()
                .setValue( buildChatMessage(timestamp, message) );
    }

    private ChatMessage buildChatMessage(@NonNull Date timestamp, @NonNull String message) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setId( timestamp.getTime() );
        chatMessage.setMessage( message );
        chatMessage.setUser( FirebaseAuth.getInstance().getCurrentUser().getDisplayName() );
        chatMessage.setMessageDate( timestamp );

        return chatMessage;
    }
}
