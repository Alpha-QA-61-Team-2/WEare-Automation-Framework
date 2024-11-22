package wearetests.web;

import org.junit.jupiter.api.*;
import wearetests.core.WEareBaseWebTest;
import wearetests.enums.TestData;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AddAndApproveFriendRequestTest extends WEareBaseWebTest {

    public static final String ERROR_MESSAGE_FOR_APPROVING_FRIEND_REQUEST = "There are no friend requests to approve!";
    public static final String ERROR_MESSAGE_FOR_SENDING_FRIEND_REQUEST = "Friend request send message should be displayed but is not!.";

    @Test
    @Order(1)
    public void friendRequestSent_when_validCredentialsProvided() {
        authenticateWithUser(TestData.USER_1.getValue());
        homePage.goToUserPage();
        profilePage.sendConnectionRequest();
        Assertions.assertTrue(profilePage.isSuccessMsgDisplayed(), ERROR_MESSAGE_FOR_SENDING_FRIEND_REQUEST);
    }

    @Test
    @Order(2)
    public void friendRequestApproved_when_validCredentialsProvided() {
        authenticateWithUser(TestData.USER_3.getValue());
        homePage.selectPersonalProfile();
        personalProfilePage.seeNewFriendRequests();
        connectionRequestsPage.approveFriendRequest();
        Assertions.assertTrue(connectionRequestsPage.isSuccessMsgDisplayed(), ERROR_MESSAGE_FOR_APPROVING_FRIEND_REQUEST);
    }
}
