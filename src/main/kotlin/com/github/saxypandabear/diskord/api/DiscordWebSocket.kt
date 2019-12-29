package com.github.saxypandabear.diskord.api

import java.io.IOException
import java.net.Socket
import java.net.SocketAddress
import java.net.SocketOption
import java.nio.ByteBuffer
import java.nio.channels.*
import java.nio.channels.spi.SelectorProvider

class DiscordWebSocket : SocketChannel(SelectorProvider.provider()) {
    /**
     * @throws  NotYetConnectedException
     * If this channel is not yet connected
     */
    override fun write(src: ByteBuffer?): Int {
        throw NotYetConnectedException()
    }

    /**
     * @throws  NotYetConnectedException
     * If this channel is not yet connected
     */
    override fun write(srcs: Array<out ByteBuffer>?, offset: Int, length: Int): Long {
        throw NotYetConnectedException()
    }

    /**
     * Connects this channel's socket.
     *
     *
     *  If this channel is in non-blocking mode then an invocation of this
     * method initiates a non-blocking connection operation.  If the connection
     * is established immediately, as can happen with a local connection, then
     * this method returns <tt>true</tt>.  Otherwise this method returns
     * <tt>false</tt> and the connection operation must later be completed by
     * invoking the [finishConnect][.finishConnect] method.
     *
     *
     *  If this channel is in blocking mode then an invocation of this
     * method will block until the connection is established or an I/O error
     * occurs.
     *
     *
     *  This method performs exactly the same security checks as the [ ] class.  That is, if a security manager has been
     * installed then this method verifies that its [ ][java.lang.SecurityManager.checkConnect] method permits
     * connecting to the address and port number of the given remote endpoint.
     *
     *
     *  This method may be invoked at any time.  If a read or write
     * operation upon this channel is invoked while an invocation of this
     * method is in progress then that operation will first block until this
     * invocation is complete.  If a connection attempt is initiated but fails,
     * that is, if an invocation of this method throws a checked exception,
     * then the channel will be closed.
     *
     * @param  remote
     * The remote address to which this channel is to be connected
     *
     * @return  <tt>true</tt> if a connection was established,
     * <tt>false</tt> if this channel is in non-blocking mode
     * and the connection operation is in progress
     *
     * @throws  AlreadyConnectedException
     * If this channel is already connected
     *
     * @throws  ConnectionPendingException
     * If a non-blocking connection operation is already in progress
     * on this channel
     *
     * @throws  ClosedChannelException
     * If this channel is closed
     *
     * @throws  AsynchronousCloseException
     * If another thread closes this channel
     * while the connect operation is in progress
     *
     * @throws  ClosedByInterruptException
     * If another thread interrupts the current thread
     * while the connect operation is in progress, thereby
     * closing the channel and setting the current thread's
     * interrupt status
     *
     * @throws  UnresolvedAddressException
     * If the given remote address is not fully resolved
     *
     * @throws  UnsupportedAddressTypeException
     * If the type of the given remote address is not supported
     *
     * @throws  SecurityException
     * If a security manager has been installed
     * and it does not permit access to the given remote endpoint
     *
     * @throws  IOException
     * If some other I/O error occurs
     */
    override fun connect(remote: SocketAddress?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * Tells whether or not this channel's network socket is connected.
     *
     * @return  <tt>true</tt> if, and only if, this channel's network socket
     * is [open][.isOpen] and connected
     */
    override fun isConnected(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * Returns a set of the socket options supported by this channel.
     *
     *
     * This method will continue to return the set of options even after the
     * channel has been closed.
     *
     * @return  A set of the socket options supported by this channel
     */
    override fun supportedOptions(): MutableSet<SocketOption<*>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * Retrieves a socket associated with this channel.
     *
     *
     * The returned object will not declare any public methods that are not
     * declared in the [java.net.Socket] class.
     *
     * @return  A socket associated with this channel
     */
    override fun socket(): Socket {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * Tells whether or not a connection operation is in progress on this
     * channel.
     *
     * @return  <tt>true</tt> if, and only if, a connection operation has been
     * initiated on this channel but not yet completed by invoking the
     * [finishConnect][.finishConnect] method
     */
    override fun isConnectionPending(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * Shutdown the connection for reading without closing the channel.
     *
     *
     *  Once shutdown for reading then further reads on the channel will
     * return `-1`, the end-of-stream indication. If the input side of the
     * connection is already shutdown then invoking this method has no effect.
     *
     * @return  The channel
     *
     * @throws  NotYetConnectedException
     * If this channel is not yet connected
     * @throws  ClosedChannelException
     * If this channel is closed
     * @throws  IOException
     * If some other I/O error occurs
     *
     * @since 1.7
     */
    override fun shutdownInput(): SocketChannel {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * @throws  NotYetConnectedException
     * If this channel is not yet connected
     */
    override fun read(dst: ByteBuffer?): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * @throws  NotYetConnectedException
     * If this channel is not yet connected
     */
    override fun read(dsts: Array<out ByteBuffer>?, offset: Int, length: Int): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * Adjusts this channel's blocking mode.
     *
     *
     *  This method is invoked by the [ configureBlocking][.configureBlocking] method in order to perform the actual work of
     * changing the blocking mode.  This method is only invoked if the new mode
     * is different from the current mode.
     *
     * @param  block  If <tt>true</tt> then this channel will be placed in
     * blocking mode; if <tt>false</tt> then it will be placed
     * non-blocking mode
     *
     * @throws IOException
     * If an I/O error occurs
     */
    override fun implConfigureBlocking(block: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * {@inheritDoc}
     *
     *
     * If there is a security manager set, its `checkConnect` method is
     * called with the local address and `-1` as its arguments to see
     * if the operation is allowed. If the operation is not allowed,
     * a `SocketAddress` representing the
     * [loopback][java.net.InetAddress.getLoopbackAddress] address and the
     * local port of the channel's socket is returned.
     *
     * @return  The `SocketAddress` that the socket is bound to, or the
     * `SocketAddress` representing the loopback address if
     * denied by the security manager, or `null` if the
     * channel's socket is not bound
     *
     * @throws  ClosedChannelException     {@inheritDoc}
     * @throws  IOException                {@inheritDoc}
     */
    override fun getLocalAddress(): SocketAddress {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * Returns the value of a socket option.
     *
     * @param   <T>
     * The type of the socket option value
     * @param   name
     * The socket option
     *
     * @return  The value of the socket option. A value of `null` may be
     * a valid value for some socket options.
     *
     * @throws  UnsupportedOperationException
     * If the socket option is not supported by this channel
     * @throws  ClosedChannelException
     * If this channel is closed
     * @throws  IOException
     * If an I/O error occurs
     *
     * @see java.net.StandardSocketOptions
    </T> */
    override fun <T> getOption(name: SocketOption<T>?): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * @throws  UnsupportedOperationException           {@inheritDoc}
     * @throws  IllegalArgumentException                {@inheritDoc}
     * @throws  ClosedChannelException                  {@inheritDoc}
     * @throws  IOException                             {@inheritDoc}
     *
     * @since 1.7
     */
    override fun <T> setOption(name: SocketOption<T>?, value: T): SocketChannel {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * Closes this selectable channel.
     *
     *
     *  This method is invoked by the [ close][java.nio.channels.Channel.close] method in order to perform the actual work of closing the
     * channel.  This method is only invoked if the channel has not yet been
     * closed, and it is never invoked more than once.
     *
     *
     *  An implementation of this method must arrange for any other thread
     * that is blocked in an I/O operation upon this channel to return
     * immediately, either by throwing an exception or by returning normally.
     *
     *
     * @throws  IOException
     * If an I/O error occurs
     */
    override fun implCloseSelectableChannel() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * @throws  ConnectionPendingException
     * If a non-blocking connect operation is already in progress on
     * this channel
     * @throws  AlreadyBoundException               {@inheritDoc}
     * @throws  UnsupportedAddressTypeException     {@inheritDoc}
     * @throws  ClosedChannelException              {@inheritDoc}
     * @throws  IOException                         {@inheritDoc}
     * @throws  SecurityException
     * If a security manager has been installed and its
     * [checkListen][SecurityManager.checkListen] method denies
     * the operation
     *
     * @since 1.7
     */
    override fun bind(local: SocketAddress?): SocketChannel {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * Finishes the process of connecting a socket channel.
     *
     *
     *  A non-blocking connection operation is initiated by placing a socket
     * channel in non-blocking mode and then invoking its [ connect][.connect] method.
     * Once the connection is established, or the attempt has
     * failed, the socket channel will become connectable and this method may
     * be invoked to complete the connection sequence.  If the connection
     * operation failed then invoking this method will cause an appropriate
     * [java.io.IOException] to be thrown.
     *
     *
     *  If this channel is already connected then this method will not block
     * and will immediately return <tt>true</tt>.  If this channel is in
     * non-blocking mode then this method will return <tt>false</tt> if the
     * connection process is not yet complete.  If this channel is in blocking
     * mode then this method will block until the connection either completes
     * or fails, and will always either return <tt>true</tt> or throw a checked
     * exception describing the failure.
     *
     *
     *  This method may be invoked at any time.  If a read or write
     * operation upon this channel is invoked while an invocation of this
     * method is in progress then that operation will first block until this
     * invocation is complete.  If a connection attempt fails, that is, if an
     * invocation of this method throws a checked exception, then the channel
     * will be closed.
     *
     * @return  <tt>true</tt> if, and only if, this channel's socket is now
     * connected
     *
     * @throws  NoConnectionPendingException
     * If this channel is not connected and a connection operation
     * has not been initiated
     *
     * @throws  ClosedChannelException
     * If this channel is closed
     *
     * @throws  AsynchronousCloseException
     * If another thread closes this channel
     * while the connect operation is in progress
     *
     * @throws  ClosedByInterruptException
     * If another thread interrupts the current thread
     * while the connect operation is in progress, thereby
     * closing the channel and setting the current thread's
     * interrupt status
     *
     * @throws  IOException
     * If some other I/O error occurs
     */
    override fun finishConnect(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * Shutdown the connection for writing without closing the channel.
     *
     *
     *  Once shutdown for writing then further attempts to write to the
     * channel will throw [ClosedChannelException]. If the output side of
     * the connection is already shutdown then invoking this method has no
     * effect.
     *
     * @return  The channel
     *
     * @throws  NotYetConnectedException
     * If this channel is not yet connected
     * @throws  ClosedChannelException
     * If this channel is closed
     * @throws  IOException
     * If some other I/O error occurs
     *
     * @since 1.7
     */
    override fun shutdownOutput(): SocketChannel {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * Returns the remote address to which this channel's socket is connected.
     *
     *
     *  Where the channel is bound and connected to an Internet Protocol
     * socket address then the return value from this method is of type [ ].
     *
     * @return  The remote address; `null` if the channel's socket is not
     * connected
     *
     * @throws  ClosedChannelException
     * If the channel is closed
     * @throws  IOException
     * If an I/O error occurs
     *
     * @since 1.7
     */
    override fun getRemoteAddress(): SocketAddress {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}