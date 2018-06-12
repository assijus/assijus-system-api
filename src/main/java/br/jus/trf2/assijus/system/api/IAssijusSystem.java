package br.jus.trf2.assijus.system.api;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.crivano.swaggerservlet.ISwaggerMethod;
import com.crivano.swaggerservlet.ISwaggerModel;
import com.crivano.swaggerservlet.ISwaggerRequest;
import com.crivano.swaggerservlet.ISwaggerResponse;
import com.crivano.swaggerservlet.ISwaggerResponseFile;

public interface IAssijusSystem {
	public class Document implements ISwaggerModel {
		public String id;
		public String secret;
		public String code;
		public String descr;
		public String kind;
		public String origin;
		public String extra;
	}

	public class Signature implements ISwaggerModel {
		public String ref;
		public String signer;
		public String kind;
	}

	public class Movement implements ISwaggerModel {
		public Date time;
		public String department;
		public String kind;
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
		public void run(DocListGetRequest req, DocListGetResponse resp) throws Exception;
	}

	public class DocIdPdfGetRequest implements ISwaggerRequest {
		public String id;
		public String cpf;
	}

	public class DocIdPdfGetResponse implements ISwaggerResponse, ISwaggerResponseFile {
		public String contenttype = "application/pdf";
		public String contentdisposition = "attachment";
		public Long contentlength;
		public InputStream inputstream;
		public Map<String, List<String>> headerFields;

		public String getContenttype() {
			return contenttype;
		}

		public void setContenttype(String contenttype) {
			this.contenttype = contenttype;
		}

		public String getContentdisposition() {
			return contentdisposition;
		}

		public void setContentdisposition(String contentdisposition) {
			this.contentdisposition = contentdisposition;
		}

		public Long getContentlength() {
			return contentlength;
		}

		public void setContentlength(Long contentlength) {
			this.contentlength = contentlength;
		}

		public InputStream getInputstream() {
			return inputstream;
		}

		public void setInputstream(InputStream inputstream) {
			this.inputstream = inputstream;
		}

		public Map<String, List<String>> getHeaderFields() {
			return headerFields;
		}

		public void setHeaderFields(Map<String, List<String>> headerFields) {
			this.headerFields = headerFields;
		}
	}

	public interface IDocIdPdfGet extends ISwaggerMethod {
		public void run(DocIdPdfGetRequest req, DocIdPdfGetResponse resp) throws Exception;
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
		public String secret;
	}

	public interface IDocIdHashGet extends ISwaggerMethod {
		public void run(DocIdHashGetRequest req, DocIdHashGetResponse resp) throws Exception;
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
		public void run(DocIdSignPutRequest req, DocIdSignPutResponse resp) throws Exception;
	}

	public class DocIdInfoGetRequest implements ISwaggerRequest {
		public String id;
	}

	public class DocIdInfoGetResponse implements ISwaggerResponse {
		public String status;
		public List<Signature> signature;
		public List<Movement> movement;
		public String secret;
	}

	public interface IDocIdInfoGet extends ISwaggerMethod {
		public void run(DocIdInfoGetRequest req, DocIdInfoGetResponse resp) throws Exception;
	}

	public class SignRefGetRequest implements ISwaggerRequest {
		public String ref;
	}

	public class SignRefGetResponse implements ISwaggerResponse {
		public byte[] envelope;
		public Date time;
	}

	public interface ISignRefGet extends ISwaggerMethod {
		public void run(SignRefGetRequest req, SignRefGetResponse resp) throws Exception;
	}

}