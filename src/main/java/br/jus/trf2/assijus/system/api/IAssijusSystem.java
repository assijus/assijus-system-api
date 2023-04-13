package br.jus.trf2.assijus.system.api;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.crivano.swaggerservlet.ISwaggerMethod;
import com.crivano.swaggerservlet.ISwaggerModel;
import com.crivano.swaggerservlet.ISwaggerRequest;
import com.crivano.swaggerservlet.ISwaggerResponse;
import com.crivano.swaggerservlet.ISwaggerResponseFile;

public interface IAssijusSystem {
	public static class Document implements ISwaggerModel {
		public String id;
		public String secret;
		public String code;
		public String descr;
		public String kind;
		public String origin;
		public String extra;
	}

	public static class Signature implements ISwaggerModel {
		public String ref;
		public String signer;
		public String kind;
	}

	public static class Movement implements ISwaggerModel {
		public Date time;
		public String department;
		public String kind;
	}

	public static class Warning implements ISwaggerModel {
		public String label;
		public String description;
	}

	public static class Error implements ISwaggerModel {
		public String error;
	}

	public interface IDocListGet extends ISwaggerMethod {
		public static class Request implements ISwaggerRequest {
			public String cpf;
			public String urlapi;
		}

		public static class Response implements ISwaggerResponse {
			public List<Document> list = new ArrayList<>();
		}

		public void run(Request req, Response resp, AssijusSystemContext ctx) throws Exception;
	}

	public interface IDocIdPdfGet extends ISwaggerMethod {
		public static class Request implements ISwaggerRequest {
			public String id;
			public String cpf;
		}

		public static class Response implements ISwaggerResponse, ISwaggerResponseFile {
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

		public void run(Request req, Response resp, AssijusSystemContext ctx) throws Exception;
	}

	public interface IDocIdHashGet extends ISwaggerMethod {
		public static class Request implements ISwaggerRequest {
			public String id;
			public String cpf;
			public String extra;
		}

		public static class Response implements ISwaggerResponse {
			public byte[] sha1;
			public byte[] sha256;
			public String policy;
			public String extra;
			public byte[] doc;
			public String secret;
		}

		public void run(Request req, Response resp, AssijusSystemContext ctx) throws Exception;
	}

	public interface IDocIdSignPut extends ISwaggerMethod {
		public static class Request implements ISwaggerRequest {
			public String id;
			public String cpf;
			public String name;
			public Date time;
			public byte[] sha1;
			public String extra;
			public byte[] envelope;
		}

		public static class Response implements ISwaggerResponse {
			public String status;
			public List<Warning> warning = new ArrayList<>();
		}

		public void run(Request req, Response resp, AssijusSystemContext ctx) throws Exception;
	}

	public interface IDocIdInfoGet extends ISwaggerMethod {
		public static class Request implements ISwaggerRequest {
			public String id;
		}

		public static class Response implements ISwaggerResponse {
			public String status;
			public List<Signature> signature = new ArrayList<>();
			public List<Movement> movement = new ArrayList<>();
			public String secret;
		}

		public void run(Request req, Response resp, AssijusSystemContext ctx) throws Exception;
	}

	public interface ISignRefGet extends ISwaggerMethod {
		public static class Request implements ISwaggerRequest {
			public String ref;
		}

		public static class Response implements ISwaggerResponse {
			public byte[] envelope;
			public Date time;
		}

		public void run(Request req, Response resp, AssijusSystemContext ctx) throws Exception;
	}

}

