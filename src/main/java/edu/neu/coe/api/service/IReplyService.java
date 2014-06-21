package edu.neu.coe.api.service;

import java.io.Serializable;
import java.util.List;

import edu.neu.coe.api.model.City;
import edu.neu.coe.api.model.Reply;
import edu.neu.coe.api.model.Topic;
import edu.neu.coe.api.model.User;
import edu.neu.coe.api.model.Photo;

public interface IReplyService extends IAbstractService<Reply,Integer>{


	public List<Reply> getAll();
}
