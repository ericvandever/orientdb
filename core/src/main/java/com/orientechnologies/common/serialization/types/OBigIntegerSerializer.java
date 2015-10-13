package com.orientechnologies.common.serialization.types;

import com.orientechnologies.common.directmemory.ODirectMemoryPointer;
import com.orientechnologies.orient.core.storage.impl.local.paginated.wal.OWALChangesTree;

import java.math.BigInteger;

public class OBigIntegerSerializer implements OBinarySerializer<BigInteger> {
		public static final OBigIntegerSerializer INSTANCE = new OBigIntegerSerializer();
		public static final byte               ID       = 24;

		public int getObjectSize(BigInteger object, Object... hints) {
			return OBinaryTypeSerializer.INSTANCE.getObjectSize(object.toByteArray());
		}

		public int getObjectSize(byte[] stream, int startPosition) {
			return OBinaryTypeSerializer.INSTANCE.getObjectSize(stream, startPosition);
		}

		public void serialize(BigInteger object, byte[] stream, int startPosition, Object... hints) {
			OBinaryTypeSerializer.INSTANCE.serialize(object.toByteArray(), stream, startPosition);
		}

		public BigInteger deserialize(final byte[] stream, int startPosition) {
			return new BigInteger(OBinaryTypeSerializer.INSTANCE.deserialize(stream, startPosition));
		}

		public byte getId() {
			return ID;
		}

		public int getObjectSizeNative(final byte[] stream, final int startPosition) {
			return OBinaryTypeSerializer.INSTANCE.getObjectSizeNative(stream, startPosition);
		}

		@Override
		public void serializeNativeObject(BigInteger object, byte[] stream, int startPosition, Object... hints) {
			OBinaryTypeSerializer.INSTANCE.serializeNativeObject(object.toByteArray(), stream, startPosition);
		}

		@Override
		public BigInteger deserializeNativeObject(byte[] stream, int startPosition) {
			return new BigInteger(OBinaryTypeSerializer.INSTANCE.deserializeNativeObject(stream, startPosition));
		}

		@Override
		public void serializeInDirectMemoryObject(BigInteger object, ODirectMemoryPointer pointer, long offset, Object... hints) {
			OBinaryTypeSerializer.INSTANCE.serializeInDirectMemoryObject(object.toByteArray(), pointer, offset);
		}

		@Override
		public BigInteger deserializeFromDirectMemoryObject(ODirectMemoryPointer pointer, long offset) {
			return new BigInteger(OBinaryTypeSerializer.INSTANCE.deserializeFromDirectMemoryObject(pointer, offset));
		}

		@Override
		public BigInteger deserializeFromDirectMemoryObject(OWALChangesTree.PointerWrapper wrapper, long offset) {
			return new BigInteger(OBinaryTypeSerializer.INSTANCE.deserializeFromDirectMemoryObject(wrapper, offset));
		}

		@Override
		public int getObjectSizeInDirectMemory(ODirectMemoryPointer pointer, long offset) {
			return OBinaryTypeSerializer.INSTANCE.getObjectSizeInDirectMemory(pointer, offset);
		}

		@Override
		public int getObjectSizeInDirectMemory(OWALChangesTree.PointerWrapper wrapper, long offset) {
			return OBinaryTypeSerializer.INSTANCE.getObjectSizeInDirectMemory(wrapper, offset);
		}

		public boolean isFixedLength() {
			return false;
		}

		public int getFixedLength() {
			return 0;
		}

		@Override
		public BigInteger preprocess(BigInteger value, Object... hints) {
			return value;
		}
}
