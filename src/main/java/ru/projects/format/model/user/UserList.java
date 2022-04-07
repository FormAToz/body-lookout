package ru.projects.format.model.user;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.apache.commons.collections4.ListUtils;
import ru.projects.format.constant.AttributeName;
import ru.projects.format.model.ModelAttribute;

import java.util.List;

@Setter
@AllArgsConstructor
public class UserList implements ModelAttribute {
    private List<User> userList;

    public List<User> getUserList() {
        return ListUtils.emptyIfNull(userList);
    }

    @Override
    public @NonNull String getAttributeName() {
        return AttributeName.USER_LIST;
    }

    @Override
    public String toString() {
        return "UserList{" +
                "userList=" + userList +
                '}';
    }
}