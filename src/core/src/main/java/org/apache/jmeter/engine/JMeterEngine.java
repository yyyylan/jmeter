/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.jmeter.engine;

import java.util.Properties;

import org.apache.jorphan.collections.HashTree;

/**
 * This interface is implemented by classes that can run JMeter tests.
 * 这个借口可以由jmeter测试类实现
 */
public interface JMeterEngine {
    /**
     * Configure engine
     * @param testPlan the test plan
     */
    void configure(HashTree testPlan);

    /**
     * Runs the test
     * @throws JMeterEngineException if an error occurs
     */
    void runTest() throws JMeterEngineException;

    /**
     * Stop test immediately interrupting current samplers
     *停止测试立即中断当前采样器
     */
    default void stopTest() {
        stopTest(true);
    }
    /**
     *
     * @param now boolean that tell whether stop is immediate (interrupt) or not (wait for current sample end)
     *            布尔类型觉定是否立即停止或是等待当前采样器结束后停止
     */
    void stopTest(boolean now);

    /**
     * Stop test if running
     * 如果正在运行请停止测试
     */
    void reset();

    /**
     * set Properties on engine
     * @param p the properties to set
     */
    void setProperties(Properties p);

    /**
     * Exit engine
     */
    void exit();

    /**
     * @return boolean Flag to show whether engine is active (true when test is running). Set to false at end of test
     * 布尔类型显示引擎是否处于活跃状态（当测试运行时为true）测试结束时设置为false
     */
    boolean isActive();
}
