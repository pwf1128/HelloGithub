package com.bdht.smack;

import java.io.IOException;

import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.ConnectionConfiguration.SecurityMode;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.SmackException.NotConnectedException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.chat.Chat;
import org.jivesoftware.smack.chat.ChatManager;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;

public class HelloSmack {
	
	public void init() {
		// Create a connection to the jabber.org server on a specific port.
		XMPPTCPConnectionConfiguration config = XMPPTCPConnectionConfiguration.builder()
//		  .setUsernameAndPassword("pwf", "123456")
//				  .setServiceName("bdht-2016051604")
				  .setServiceName("bdht-2016051604")
				  .setHost("bdht-2016051604")
				  .setSecurityMode(SecurityMode.disabled)
//				  .setCustomSSLContext(context)
				  
//		  .setHost("bdht-2016051604")
//		  .setPort(5222)
		  .build();

		AbstractXMPPConnection connection = new XMPPTCPConnection(config);
		

//		AbstractXMPPConnection conn = new XMPPTCPConnection("pwf", "123456", "BDHT-2016051604");
//		AbstractXMPPConnection conn = new XMPPTCPConnection("pwf", "123456", "192.168.1.121");
		
		try {
			connection.connect();
			
			connection.login("pwf1", "123456");
			
		} catch (SmackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
				
		} catch (XMPPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
				
		}
		System.out.println(connection.getUser());
		
		ChatManager chatmanager = ChatManager.getInstanceFor(connection);
		Chat newChat = chatmanager.createChat("admin");
		
//		Chat newChat = chatmanager.createChat("jsmith@jivesoftware.com", new MessageListener() {
//			public void processMessage(Chat chat, Message message) {
//				System.out.println("Received message: " + message);
//			}
//		});
		
		try {
			newChat.sendMessage("hello!!");
		} catch (NotConnectedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
				
		}
//		connection.get
//		connection.getChatManager().createChat("shimiso@csdn.shimiso.com",null).sendMessage("Hello word!");
		
		connection.disconnect();
		
		System.out.println("end");
	}

	public static void main(String[] arr) {
		HelloSmack s = new HelloSmack();
		s.init();
	}
}