package com.example.messenger;

import java.util.Date;


 /**
 *  Class Conversation is a Java Bean class the represents a single chat conversation message
 */
public class Conversation
{

	/** The Constant STATUS_SENDING. */
	public static final int STATUS_SENDING = 0;

	/** The Constant STATUS_SENT. */
	public static final int STATUS_SENT = 1;

	/** The Constant STATUS_FAILED. */
	public static final int STATUS_FAILED = 2;
	/** The msg. */
	private String msg;

	/** The status. */
	private int status = STATUS_SENT;

	/** The date. */
	private Date date;

	/** The sender. */
	private String sender;

	/**
	 * Instantiates a new conversation.
	 */
	public Conversation(String msg, Date date, String sender)
	{
		this.msg = msg;
		this.date = date;
		this.sender = sender;
	}

	/**
	 * Instantiates a new conversation.
	 */
	public Conversation()
	{
	}

	/**
	 * Gets the msg.
	 */
	public String getMsg()
	{
		return msg;
	}

	/**
	 * Sets the msg.
	 */
	public void setMsg(String msg)
	{
		this.msg = msg;
	}

	/**
	 * Checks if is sent.
	 * 
	 * @return true, if is sent
	 */
	public boolean isSent()
	{
		return UserList.user.getUsername().equals(sender);
	}

	/**
	 * Gets the date.
	 */
	public Date getDate()
	{
		return date;
	}

	/**
	 * Sets the date.
	 */
	public void setDate(Date date)
	{
		this.date = date;
	}

	/**
	 * Gets the sender.
	 */
	public String getSender()
	{
		return sender;
	}

	/**
	 * Sets the sender.
	 */
	public void setSender(String sender)
	{
		this.sender = sender;
	}

	/**
	 * Gets the status.
	 */
	public int getStatus()
	{
		return status;
	}

	/**
	 * Sets the status.
	 */
	public void setStatus(int status)
	{
		this.status = status;
	}

}
