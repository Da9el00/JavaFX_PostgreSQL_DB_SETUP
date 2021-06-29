package org.example.domain;

import java.util.List;

public interface IPersistenceHandler {

    public List<Friend> getFriends();

    public boolean createFriend(Friend friend);
}
