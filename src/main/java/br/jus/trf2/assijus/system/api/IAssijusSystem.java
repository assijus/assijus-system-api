package br.jus.trf2.assijus.system.api;

import java.util.Date;
import java.util.List;

import com.crivano.swaggerservlet.ISwaggerMethod;
import com.crivano.swaggerservlet.ISwaggerModel;
import com.crivano.swaggerservlet.ISwaggerRequest;
import com.crivano.swaggerservlet.ISwaggerResponse;

public interface IAssijusSystem {
	public class Document implements ISwaggerModel {
		public String id;
		public String code;
		public String descr;
		public String kind;
		public String origin;
		public String extra;
	}

	public class Warning implements ISwaggerModel {
		public String label;
		public String description;
	}

	public class Error implements ISwaggerModel {
		public String error;
	}

	public class DocListGetRequest implements ISwaggerRequest {
		public String cpf;
		public String urlapi;
	}

	public class DocListGetResponse implements ISwaggerResponse {
		public List<Document> list;
	}

	public interface IDocListGet extends ISwaggerMethod {
		public void run(DocListGetRequest req, DocListGetResponse resp)
				throws Exception;
	}

	public class DocIdPdfGetRequest implements ISwaggerRequest {
		public String id;
		public String cpf;
	}

	public class DocIdPdfGetResponse implements ISwaggerResponse {
		public byte[] doc;
	}

	public interface IDocIdPdfGet extends ISwaggerMethod {
		public void run(DocIdPdfGetRequest req, DocIdPdfGetResponse resp)
				throws Exception;
	}

	public class DocIdHashGetRequest implements ISwaggerRequest {
		public String id;
		public String cpf;
		public String extra;
	}

	public class DocIdHashGetResponse implements ISwaggerResponse {
		public byte[] sha1;
		public byte[] sha256;
		public String policy;
		public String extra;
		public byte[] doc;
	}

	public interface IDocIdHashGet extends ISwaggerMethod {
		public void run(DocIdHashGetRequest req, DocIdHashGetResponse resp)
				throws Exception;
	}

	public class DocIdSignPutRequest implements ISwaggerRequest {
		public String id;
		public String cpf;
		public String name;
		public Date time;
		public byte[] sha1;
		public String extra;
		public byte[] envelope;
	}

	public class DocIdSignPutResponse implements ISwaggerResponse {
		public String status;
		public List<Warning> warning;
	}

	public interface IDocIdSignPut extends ISwaggerMethod {
		public void run(DocIdSignPutRequest req, DocIdSignPutResponse resp)
				throws Exception;
	}

}
